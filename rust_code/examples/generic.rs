use std::fmt::Debug;
struct Pair<T: Debug, U: Debug> {
    first: T,
    second: U,
}

impl<T: Debug, U: Debug> Pair<T, U> {
    fn new(first: T, second: U) -> Self {
        Pair { first, second }
    }
}

fn print_pair<T: Debug, U: Debug>(pair: &Pair<T, U>) {
    println!("First: {:?}", pair.first);
    println!("Second: {:?}", pair.second);
}

fn main() {
    let p1 = Pair::new(10, "Hello");
    let p2 = Pair::new(3.14, true);

    print_pair(&p1);
    print_pair(&p2);
}
