use std::env;
use std::fs;
use std::path::Path;
use std::process::exit;

fn find_in_directory(path: &Path, pattern: &str) -> std::io::Result<()> {
    for entry in fs::read_dir(path)? {
        let entry = entry?;
        let path = entry.path();

        if path.is_dir() {
            find_in_directory(&path, pattern)?;
        }

        if path.is_file()
            && path
                .file_name()
                .unwrap()
                .to_str()
                .unwrap()
                .contains(pattern)
        {
            println!("{}", path.display());
        }
    }
    Ok(())
}

fn main() -> std::io::Result<()> {
    let args: Vec<String> = env::args().collect();

    // 至少需要两个参数：目录和模式
    if args.len() < 3 {
        eprintln!("Usage: find <directory> <pattern>");
        exit(1);
    }

    let dir = &args[1];
    let pattern = &args[2];

    let path = Path::new(dir);

    if path.exists() && path.is_dir() {
        find_in_directory(path, pattern)?;
    } else {
        eprintln!("Error: Directory does not exist.");
        exit(1);
    }

    Ok(())
}
