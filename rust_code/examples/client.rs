use std::io::{self, Read, Write};
use std::net::TcpStream;
use std::thread;

fn handle_server(mut stream: TcpStream) {
    let mut buffer = [0; 512];
    loop {
        match stream.read(&mut buffer) {
            Ok(0) => break, // 服务器关闭连接
            Ok(n) => {
                let message = String::from_utf8_lossy(&buffer[..n]);
                println!("{}", message);
            }
            Err(_) => break, // 出错断开连接
        }
    }
}

fn main() {
    let address = "127.0.0.1:7878";
    match TcpStream::connect(address) {
        Ok(mut stream) => {
            println!("Connected to server!");

            // 在单独的线程中接收消息
            let stream_clone = stream.try_clone().expect("Failed to clone stream");
            thread::spawn(move || {
                handle_server(stream_clone);
            });

            // 获取用户名
            let mut username = String::new();
            io::stdout().flush().unwrap();
            io::stdin().read_line(&mut username).unwrap();
            let username = username.trim();

            stream.write(username.as_bytes()).unwrap();

            loop {
                let mut message = String::new();
                print!("Enter message: ");
                io::stdout().flush().unwrap();
                io::stdin().read_line(&mut message).unwrap();

                if message.trim().to_lowercase() == "exit" {
                    break;
                }

                stream.write(message.as_bytes()).unwrap();
            }
        }
        Err(e) => eprintln!("Failed to connect to server: {}", e),
    }
}
