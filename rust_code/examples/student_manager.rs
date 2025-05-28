use std::collections::HashMap;
use std::io::{self, Write};

#[derive(Debug)]
struct Student {
    id: u32,
    name: String,
    age: u32,
}

struct StudentManager {
    students: HashMap<u32, Student>, // 使用 HashMap 存储学生信息，键是学生的 id
}

impl StudentManager {
    fn new() -> Self {
        StudentManager {
            students: HashMap::new(),
        }
    }

    // 添加学生
    fn add_student(&mut self, id: u32, name: &str, age: u32) {
        let student = Student {
            id,
            name: name.to_string(),
            age,
        };
        self.students.insert(student.id, student);
        println!("Student {} added.", name);
    }

    // 查询学生
    fn get_student(&self, id: u32) -> Option<&Student> {
        self.students.get(&id)
    }

    // 更新学生
    fn update_student(&mut self, id: u32, name: Option<&str>, age: Option<u32>) {
        if let Some(student) = self.students.get_mut(&id) {
            if let Some(new_name) = name {
                student.name = new_name.to_string();
            }
            if let Some(new_age) = age {
                student.age = new_age;
            }
            println!("Student {} updated.", id);
        } else {
            println!("Student with ID {} not found.", id);
        }
    }

    // 删除学生
    fn delete_student(&mut self, id: u32) {
        if self.students.remove(&id).is_some() {
            println!("Student with ID {} removed.", id);
        } else {
            println!("Student with ID {} not found.", id);
        }
    }

    // 显示所有学生
    fn display_all(&self) {
        if self.students.is_empty() {
            println!("No students to display.");
        } else {
            for student in self.students.values() {
                println!("{:?}", student);
            }
        }
    }
}

fn main() {
    let mut manager = StudentManager::new();

    loop {
        // 用户菜单
        println!("\nStudent Management System");
        println!("1. Add Student");
        println!("2. Get Student");
        println!("3. Update Student");
        println!("4. Delete Student");
        println!("5. Display All Students");
        println!("6. Exit");
        print!("Choose an option: ");
        io::stdout().flush().unwrap(); // 刷新输出缓冲区

        let mut option = String::new();
        io::stdin().read_line(&mut option).unwrap();
        let option: u32 = option.trim().parse().unwrap();

        match option {
            1 => {
                // 添加学生
                let mut id = String::new();
                let mut name = String::new();
                let mut age = String::new();

                print!("Enter student ID: ");
                io::stdout().flush().unwrap();
                io::stdin().read_line(&mut id).unwrap();

                print!("Enter student name: ");
                io::stdout().flush().unwrap();
                io::stdin().read_line(&mut name).unwrap();

                print!("Enter student age: ");
                io::stdout().flush().unwrap();
                io::stdin().read_line(&mut age).unwrap();

                let id: u32 = id.trim().parse().unwrap();
                let name = name.trim();
                let age: u32 = age.trim().parse().unwrap();

                manager.add_student(id, name, age);
            }
            2 => {
                // 查询学生
                print!("Enter student ID to find: ");
                io::stdout().flush().unwrap();
                let mut id = String::new();
                io::stdin().read_line(&mut id).unwrap();
                let id: u32 = id.trim().parse().unwrap();

                match manager.get_student(id) {
                    Some(student) => println!("{:?}", student),
                    None => println!("Student with ID {} not found.", id),
                }
            }
            3 => {
                // 更新学生
                print!("Enter student ID to update: ");
                io::stdout().flush().unwrap();
                let mut id = String::new();
                io::stdin().read_line(&mut id).unwrap();
                let id: u32 = id.trim().parse().unwrap();

                println!("Enter new information (leave blank to skip):");

                print!("Enter new name (or leave empty to keep current): ");
                io::stdout().flush().unwrap();
                let mut name = String::new();
                io::stdin().read_line(&mut name).unwrap();

                print!("Enter new age (or leave empty to keep current): ");
                io::stdout().flush().unwrap();
                let mut age = String::new();
                io::stdin().read_line(&mut age).unwrap();

                let name = if name.trim().is_empty() {
                    None
                } else {
                    Some(name.trim())
                };
                let age = if age.trim().is_empty() {
                    None
                } else {
                    Some(age.trim().parse().unwrap())
                };

                manager.update_student(id, name, age);
            }
            4 => {
                // 删除学生
                print!("Enter student ID to delete: ");
                io::stdout().flush().unwrap();
                let mut id = String::new();
                io::stdin().read_line(&mut id).unwrap();
                let id: u32 = id.trim().parse().unwrap();

                manager.delete_student(id);
            }
            5 => {
                // 显示所有学生
                manager.display_all();
            }
            6 => {
                // 退出程序
                println!("Exiting...");
                break;
            }
            _ => {
                println!("Invalid option, please try again.");
            }
        }
    }
}
