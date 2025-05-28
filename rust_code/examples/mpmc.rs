use std::sync::{Arc, Mutex, mpsc};
use std::thread;

fn main() {
    let (tx, rx) = mpsc::channel();
    let rx_shared = Arc::new(Mutex::new(rx));

    // 多生产者（MP）
    for i in 0..3 {
        let tx = tx.clone();
        thread::spawn(move || {
            tx.send(i).unwrap();
        });
    }

    // 多消费者（MC）
    for i in 0..3 {
        let rx = rx_shared.clone();
        thread::spawn(move || {
            let msg = rx.lock().unwrap().recv().unwrap();
            println!("consumer{i} Received: {}", msg);
        });
    }

    thread::sleep(std::time::Duration::from_secs(1));
}
