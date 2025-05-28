fn fibonacci(n: usize) -> Vec<u64> {
    let mut fib = vec![0; n];

    if n <= 1 {
        return fib;
    } else {
        fib[1] = 1;
    }

    for i in 2..=n - 1 {
        fib[i] = fib[i - 1] + fib[i - 2];
    }

    fib
}

fn main() {
    for n in 0..20 {
        let fib_sequence = fibonacci(n);
        println!("Fibonacci sequence up to {}: {:?}", n, fib_sequence);
    }
}
