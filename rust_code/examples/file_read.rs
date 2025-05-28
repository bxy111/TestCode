use std::collections::HashMap;
use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn main() -> io::Result<()> {
    let file = File::open("examples/add.rs")?;
    let mut reader = BufReader::new(file);
    let mut line = String::new();

    let mut v = Vec::new();
    v.push(1);

    let mut hm = HashMap::new();
    hm.insert(1, "hello".to_string());
    hm.insert(2, "world".to_string());

    println!("文件内容:");
    while reader.read_line(&mut line)? > 0 {
        print!("{}", line);
        line.clear();
    }

    Ok(())
}
