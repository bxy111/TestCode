fn map<F>(vec: Vec<i32>, func: F) -> Vec<i32>
where
    F: Fn(i32) -> i32,
{
    // 完成函数实现
    // vec.into_iter().map(func).collect()
    let mut ret = vec![];

    for item in vec {
        ret.push(func(item));
    }

    ret
}

fn main() {
    let numbers = vec![1, 2, 3, 4];
    let squared_numbers = map(numbers, |x| x * x);
    println!("{:?}", squared_numbers);
}
