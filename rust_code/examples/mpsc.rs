use std::sync::{mpsc, Arc, Mutex};
use std::thread;
use std::time::Duration;

fn main() {
    let (tx, rx) = mpsc::channel();
    let rx = Arc::new(Mutex::new(rx));

    // 生产者线程
    thread::spawn(move || {
        for i in 0..5 {
            println!("Producer{:?}: Sending {}", thread::current().id(), i);
            tx.send(i).unwrap();
            thread::sleep(Duration::from_secs(1));
        }
    });

    // 消费者线程
    let rx = Arc::clone(&rx);
    thread::spawn(move || {
        for _ in 0..5 {
            let msg = rx.lock().unwrap().recv().unwrap();
            println!("Consumer{:?}: Received {}", thread::current().id(), msg);
        }
    });

    // 防止 main 线程退出
    thread::sleep(Duration::from_secs(6));
}
