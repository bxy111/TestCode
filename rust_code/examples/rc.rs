use std::rc::Rc;

fn main() {
    let name = Rc::new(String::from("Hello"));

    let user = User {
        name: Rc::clone(&name),
    };

    let employee = Employee {
        name: Rc::clone(&name),
    };

    println!("{:#?}, {:#?}", user.name, employee.name);
}

#[derive(Debug)]
struct User {
    name: Rc<String>,
}

#[derive(Debug)]
struct Employee {
    name: Rc<String>,
}
