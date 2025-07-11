trait Coffee {
    fn cost(&self) -> f64;
    fn description(&self) -> String;
}

struct SimpleCoffee;
impl Coffee for SimpleCoffee {
    fn cost(&self) -> f64 {
        2.0
    }

    fn description(&self) -> String {
        "Simple coffee".to_string()
    }
}

struct MilkDecorator<T: Coffee> {
    coffee: T,
}

impl<T: Coffee> MilkDecorator<T> {
    fn new(coffee: T) -> Self {
        MilkDecorator { coffee }
    }
}

impl<T: Coffee> Coffee for MilkDecorator<T> {
    fn cost(&self) -> f64 {
        self.coffee.cost() + 0.5
    }

    fn description(&self) -> String {
        format!("{}, milk", self.coffee.description())
    }
}

struct SugarDecorator<T: Coffee> {
    coffee: T,
}

impl<T: Coffee> SugarDecorator<T> {
    fn new(coffee: T) -> Self {
        SugarDecorator { coffee }
    }
}

impl<T: Coffee> Coffee for SugarDecorator<T> {
    fn cost(&self) -> f64 {
        self.coffee.cost() + 0.2
    }

    fn description(&self) -> String {
        format!("{}, sugar", self.coffee.description())
    }
}

fn main() {
    let coffee = SimpleCoffee;
    println!("{}: ${}", coffee.description(), coffee.cost());

    let coffee_with_milk = MilkDecorator::new(coffee);
    println!(
        "{}: ${}",
        coffee_with_milk.description(),
        coffee_with_milk.cost()
    );

    let coffee_with_milk_and_sugar = SugarDecorator::new(coffee_with_milk);
    println!(
        "{}: ${}",
        coffee_with_milk_and_sugar.description(),
        coffee_with_milk_and_sugar.cost()
    );
}
