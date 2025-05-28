use std::cell::RefCell;
use std::rc::Rc;

#[derive(Debug)]
struct Node {
    value: i32,
    neighbors: RefCell<Vec<Rc<Node>>>,
}

impl Node {
    fn new(value: i32) -> Rc<Self> {
        Rc::new(Node {
            value,
            neighbors: RefCell::new(Vec::new()),
        })
    }

    fn add_neighbor(&self, neighbor: Rc<Node>) {
        self.neighbors.borrow_mut().push(neighbor);
    }
}

fn main() {
    let node1 = Node::new(1);
    let node2 = Node::new(2);
    let node3 = Node::new(3);

    node1.add_neighbor(node2.clone());
    node1.add_neighbor(node3.clone());

    println!("Node1 neighbors: {:?}", node1.neighbors.borrow());
    println!("Node2 neighbors: {:?}", node2.neighbors.borrow());
    println!("Node3 neighbors: {:?}", node3.neighbors.borrow());
}
