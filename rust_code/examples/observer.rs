trait Observer {
    fn update(&self, value: i32);
}

struct Subject {
    observers: Vec<Box<dyn Observer>>,
    value: i32,
}

impl Subject {
    fn new() -> Self {
        Subject {
            observers: Vec::new(),
            value: 0,
        }
    }

    fn add_observer(&mut self, observer: Box<dyn Observer>) {
        self.observers.push(observer);
    }

    fn set_value(&mut self, value: i32) {
        self.value = value;
        for observer in &self.observers {
            observer.update(value);
        }
    }
}

struct ConcreteObserver;

impl Observer for ConcreteObserver {
    fn update(&self, value: i32) {
        println!("Observer received value: {}", value);
    }
}

fn main() {
    let mut subject = Subject::new();
    let observer = Box::new(ConcreteObserver);
    let observer2 = Box::new(ConcreteObserver);

    subject.add_observer(observer);
    subject.add_observer(observer2);
    subject.set_value(42);
}
