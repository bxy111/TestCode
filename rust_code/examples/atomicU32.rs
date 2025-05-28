use std::sync::atomic::{AtomicU32, Ordering};

static COUNTER: AtomicU32 = AtomicU32::new(0);

fn increment() {
    COUNTER.fetch_add(1, Ordering::Relaxed); // 原子操作，无需 unsafe
}

fn main() {
    increment();
    println!("计数器的值是: {}", COUNTER.load(Ordering::Relaxed));

    increment();
    increment();

    println!("计数器的值是: {}", COUNTER.load(Ordering::Relaxed));
}
