trait Product {
    fn operation(&self);
}

struct ConcreteProductA;
impl Product for ConcreteProductA {
    fn operation(&self) {
        println!("ConcreteProductA operation");
    }
}

struct ConcreteProductB;
impl Product for ConcreteProductB {
    fn operation(&self) {
        println!("ConcreteProductB operation");
    }
}

enum ProductType {
    A,
    B,
}

struct Factory;
impl Factory {
    fn create_product(product_type: ProductType) -> Box<dyn Product> {
        match product_type {
            ProductType::A => Box::new(ConcreteProductA),
            ProductType::B => Box::new(ConcreteProductB),
        }
    }
}

fn main() {
    let product_a = Factory::create_product(ProductType::A);
    product_a.operation();

    let product_b = Factory::create_product(ProductType::B);
    product_b.operation();
}
