use lazy_static::lazy_static;
use std::sync::{Arc, Mutex};

struct Singleton {
    data: String,
}

impl Singleton {
    fn new(data: String) -> Self {
        Singleton { data }
    }

    fn get_data(&self) -> &str {
        &self.data
    }
}

lazy_static! {
    static ref INSTANCE: Arc<Mutex<Singleton>> =
        Arc::new(Mutex::new(Singleton::new("Singleton data".to_string())));
}

fn get_instance() -> Arc<Mutex<Singleton>> {
    Arc::clone(&INSTANCE)
}

fn main() {
    let instance = get_instance();
    let v = instance.lock().unwrap();
    let data = v.get_data();
    println!("{}", data);
}
