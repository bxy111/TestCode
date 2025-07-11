use std::cmp::Reverse;
use std::collections::BinaryHeap;

fn main() {
    // 1. Creating a BinaryHeap
    let mut heap = BinaryHeap::new();

    // 2. Adding elements (automatically ordered)
    heap.push(3);
    heap.push(1);
    heap.push(4);
    heap.push(1);
    heap.push(5);
    heap.push(9);

    println!("Heap after pushes: {:?}", heap);

    // 3. Peeking at the maximum element
    println!("Max element: {:?}", heap.peek());

    // 4. Popping elements (returns in max-first order)
    println!("Popped elements:");
    while let Some(num) = heap.pop() {
        println!("{}", num);
    }

    // 5. Creating a min-heap using Reverse
    let mut min_heap = BinaryHeap::new();
    min_heap.push(Reverse(3));
    min_heap.push(Reverse(1));
    min_heap.push(Reverse(4));

    println!("Min heap pops:");
    while let Some(Reverse(num)) = min_heap.pop() {
        println!("{}", num);
    }

    // 6. Heap from a vector
    let nums = vec![10, 5, 20, 15];
    let mut heap_from_vec = BinaryHeap::from(nums);
    println!("Heap from vector: {:?}", heap_from_vec);

    // 7. Custom types with Ord trait
    #[derive(Debug, Eq, PartialEq)]
    struct Task {
        priority: i32,
        description: String,
    }

    impl Ord for Task {
        fn cmp(&self, other: &Self) -> std::cmp::Ordering {
            self.priority.cmp(&other.priority)
        }
    }

    impl PartialOrd for Task {
        fn partial_cmp(&self, other: &Self) -> Option<std::cmp::Ordering> {
            Some(self.cmp(other))
        }
    }

    let mut task_heap = BinaryHeap::new();
    task_heap.push(Reverse(Task {
        priority: 3,
        description: "Low priority task".to_string(),
    }));
    task_heap.push(Reverse(Task {
        priority: 1,
        description: "High priority task".to_string(),
    }));
    task_heap.push(Reverse(Task {
        priority: 2,
        description: "Medium priority task".to_string(),
    }));

    println!("Tasks in priority order:");
    while let Some(task) = task_heap.pop() {
        println!("{:?}", task);
    }
}
