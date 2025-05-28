use std::sync::{Arc, Mutex};
use std::thread;

fn main() {
    let task_queue = Arc::new(Mutex::new(vec!["Task 1", "Task 2", "Task 3"]));

    let mut handles = vec![];

    for _ in 0..3 {
        let task_queue_clone = Arc::clone(&task_queue);
        let handle = thread::spawn(move || {
            let task = task_queue_clone.lock().unwrap().pop();
            if let Some(task) = task {
                println!("Processing: {}", task);
            }
        });
        handles.push(handle);
    }

    for handle in handles {
        handle.join().unwrap();
    }
}
