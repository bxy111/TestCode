use std::collections::HashMap;
use std::io::{self, Read, Write};
use std::net::{TcpListener, TcpStream};
use std::sync::{Arc, Mutex};
use std::thread;

const ADDRESS: &str = "127.0.0.1:7878";

fn handle_client(
    mut stream: TcpStream,
    clients: Arc<Mutex<HashMap<String, TcpStream>>>,
) -> io::Result<()> {
    let mut username = String::new();

    // 获取客户端用户名
    stream.write(b"Enter your username: ")?;
    stream.read_to_string(&mut username)?;

    let username = username.trim().to_string();
    {
        println!("{} login.", username);
        // 将新客户端加入到客户端列表
        let mut clients = clients.lock().unwrap();
        clients.insert(username.clone(), stream.try_clone()?);
    }

    loop {
        let mut buffer = [0; 512];
        match stream.read(&mut buffer) {
            Ok(0) => break, // 连接关闭
            Ok(n) => {
                let message = String::from_utf8_lossy(&buffer[..n]);
                let clients = clients.lock().unwrap();
                println!("{}", message);
                // 向所有客户端广播消息
                for (client_username, mut client_stream) in clients.iter() {
                    if client_username != &username {
                        let _ = client_stream.write_all(message.as_bytes());
                        client_stream.flush().unwrap();
                    }
                }
            }
            Err(_) => break, // 出错关闭连接
        }
    }

    // 断开客户端连接
    {
        let mut clients = clients.lock().unwrap();
        clients.remove(&username);
        println!("{} logout.", username);
    }

    Ok(())
}

fn main() -> io::Result<()> {
    let listener = TcpListener::bind(ADDRESS)?;
    let clients = Arc::new(Mutex::new(HashMap::new())); // 存储所有客户端

    println!("Server is running on {}", ADDRESS);

    for stream in listener.incoming() {
        match stream {
            Ok(stream) => {
                let clients = Arc::clone(&clients);

                // 启动一个新的线程来处理每个客户端
                thread::spawn(move || {
                    if let Err(e) = handle_client(stream, clients) {
                        eprintln!("Error: {}", e);
                    }
                });
            }
            Err(e) => eprintln!("Connection failed: {}", e),
        }
    }

    Ok(())
}
