use tokio::time::{sleep, Duration};

async fn task_one() {
    println!("任务一开始");
    sleep(Duration::from_secs(2)).await; // 模拟异步操作，等待2秒
    println!("任务一完成");
}

async fn task_two() {
    println!("任务二开始");
    sleep(Duration::from_secs(1)).await; // 模拟异步操作，等待1秒
    println!("任务二完成");
}

async fn task_three() {
    println!("任务三开始");
    sleep(Duration::from_secs(3)).await; // 模拟异步操作，等待3秒
    println!("任务三完成");
}

#[tokio::main]
async fn main() {
    // 启动并行任务
    let task1 = task_one();
    let task2 = task_two();
    let task3 = task_three();

    // 使用 `join!` 等待所有任务完成
    tokio::join!(task1, task2, task3);
}
