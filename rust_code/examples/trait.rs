trait Describable {
    fn description(&self) -> String;
}

struct Car {
    brand: String,
    model: String,
}

struct Dog {
    name: String,
    breed: String,
}

impl Describable for Car {
    fn description(&self) -> String {
        format!("A {} {}", self.brand, self.model)
    }
}

impl Describable for Dog {
    fn description(&self) -> String {
        format!("A {} dog named {}", self.breed, self.name)
    }
}

fn introduce(obj: &dyn Describable) {
    println!("{}", obj.description());
}

fn main() {
    let car = Car {
        brand: "heha".to_string(),
        model: "xixi".to_string(),
    };
    let dog = Dog {
        name: "wangcai".to_string(),
        breed: "hashiqi".to_string(),
    };

    introduce(&car);
    introduce(&dog);
}
