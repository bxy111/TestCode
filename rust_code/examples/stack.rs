// 定义一个 Stack 结构体
struct Stack<T> {
    items: Vec<T>, // 使用 Vec 存储栈元素
}

impl<T> Stack<T> {
    // 创建一个新的空栈
    fn new() -> Self {
        Stack { items: Vec::new() }
    }

    // 判断栈是否为空
    fn is_empty(&self) -> bool {
        self.items.is_empty()
    }

    // 压栈操作
    fn push(&mut self, item: T) {
        self.items.push(item);
    }

    // 弹栈操作
    fn pop(&mut self) -> Option<T> {
        self.items.pop()
    }

    // 查看栈顶元素
    fn peek(&self) -> Option<&T> {
        self.items.last()
    }
}

fn main() {
    // 创建一个栈，元素类型为 i32
    let mut stack = Stack::new();

    // 压入元素
    stack.push(10);
    stack.push(20);
    stack.push(30);

    // 查看栈顶元素
    println!("栈顶元素: {:?}", stack.peek()); // 输出: Some(30)

    // 弹出元素
    if let Some(top) = stack.pop() {
        println!("弹出的元素: {}", top); // 输出: 30
    }

    // 检查栈是否为空
    println!("栈是否为空: {}", stack.is_empty()); // 输出: false
}
