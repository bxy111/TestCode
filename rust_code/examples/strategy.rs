trait Discount {
    fn calculate(&self, price: f64) -> f64;
}

struct NoDiscount;
impl Discount for NoDiscount {
    fn calculate(&self, price: f64) -> f64 {
        price
    }
}

struct PercentageDiscount(f64);
impl Discount for PercentageDiscount {
    fn calculate(&self, price: f64) -> f64 {
        price * (1.0 - self.0 / 100.0)
    }
}

struct FixedDiscount(f64);
impl Discount for FixedDiscount {
    fn calculate(&self, price: f64) -> f64 {
        (price - self.0).max(0.0)
    }
}

struct Checkout<T: Discount> {
    discount: T,
}

impl<T: Discount> Checkout<T> {
    fn new(discount: T) -> Self {
        Checkout { discount }
    }

    fn total(&self, price: f64) -> f64 {
        self.discount.calculate(price)
    }
}

fn main() {
    let normal = Checkout::new(NoDiscount);
    println!("Normal price: {}", normal.total(100.0));

    let ten_percent = Checkout::new(PercentageDiscount(10.0));
    println!("10% off: {}", ten_percent.total(100.0));

    let twenty_off = Checkout::new(FixedDiscount(20.0));
    println!("$20 off: {}", twenty_off.total(100.0));
}
