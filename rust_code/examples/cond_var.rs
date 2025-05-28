use std::collections::VecDeque;
use std::sync::{Arc, Condvar, Mutex};
use std::thread;

fn main() {
    let queue = Arc::new((Mutex::new(VecDeque::new()), Condvar::new()));

    // 生产者线程
    let producer = {
        let queue = queue.clone();
        thread::spawn(move || {
            for i in 0..10 {
                let (lock, cvar) = &*queue;
                lock.lock().unwrap().push_back(i);
                cvar.notify_one();
                thread::sleep(std::time::Duration::from_millis(100));
            }
        })
    };

    // 消费者线程
    let consumer = thread::spawn(move || {
        let (lock, cvar) = &*queue;
        let mut count = 0;
        while count < 10 {
            let mut q = lock.lock().unwrap();
            while q.is_empty() {
                q = cvar.wait(q).unwrap();
            }
            while let Some(item) = q.pop_front() {
                println!("消费: {}", item);
                count += 1;
            }
        }
    });

    producer.join().unwrap();
    consumer.join().unwrap();
}
