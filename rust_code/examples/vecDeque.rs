use std::collections::VecDeque;

fn main() {
    let mut deque: VecDeque<i32> = VecDeque::new();

    // 向队列的两端添加元素
    deque.push_back(1);
    deque.push_back(2);
    deque.push_front(0);
    deque.push_back(3);

    println!("Deque after push operations: {:?}", deque);

    // 删除队头和队尾元素
    deque.pop_front();
    deque.pop_back();

    println!("Deque after pop operations: {:?}", deque);

    // 查看队头和队尾元素
    if let Some(front) = deque.front() {
        println!("Front element: {}", front);
    }

    if let Some(back) = deque.back() {
        println!("Back element: {}", back);
    }

    // 遍历队列中的所有元素
    println!("Iterating over deque:");
    for elem in deque.iter() {
        println!("{}", elem);
    }

    deque.pop_front();
    deque.pop_back();
    println!("Front element: {:?}", deque.front());

    println!("Back element: {:?}", deque.back());
}
