#[derive(Debug)]
struct Person {
    name: String,
    age: u32,
}

struct PersonBuilder {
    name: Option<String>,
    age: Option<u32>,
}

impl PersonBuilder {
    // 创建一个新的 PersonBuilder 实例
    fn new() -> Self {
        PersonBuilder {
            name: None,
            age: None,
        }
    }

    // 设置 name
    fn name(mut self, name: &str) -> Self {
        self.name = Some(name.to_string());
        self
    }

    // 设置 age
    fn age(mut self, age: u32) -> Self {
        self.age = Some(age);
        self
    }

    // 构建 Person 对象
    fn build(self) -> Result<Person, &'static str> {
        if let (Some(name), Some(age)) = (self.name, self.age) {
            Ok(Person { name, age })
        } else {
            Err("Missing fields to build Person")
        }
    }
}

fn main() {
    // 使用链式调用创建 Person 对象
    let person = PersonBuilder::new().name("Alice").age(30).build();

    match person {
        Ok(p) => println!("{:?}", p),
        Err(e) => println!("Error: {}", e),
    }
}
