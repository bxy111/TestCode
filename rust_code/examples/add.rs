use std::ops::Add;

fn main() {
    let p1 = Point { x: 1, y: 2 };
    let p2 = Point { x: 2, y: 3 };

    let res = add_ref(&p1, &p2);

    println!("{:?} add {:?} result is {:?}", p1, p2, res);
}

// fn add<T: Add<Output = T>>(a: T, b: T) -> T {
//     a + b
// }

fn add_ref<T>(a: &T, b: &T) -> T
where
    for<'a> &'a T: Add<Output = T>,
{
    a + b
}

#[derive(Debug)]
struct Point {
    x: i32,
    y: i32,
}

// impl Add for Point {
//     type Output = Self;

//     fn add(self, rhs: Self) -> Self {
//         Self {
//             x: self.x + rhs.x,
//             y: self.y + rhs.y,
//         }
//     }
// }

impl Add for &Point {
    type Output = Point;

    fn add(self, rhs: Self) -> Point {
        Point {
            x: self.x + rhs.x,
            y: self.y + rhs.y,
        }
    }
}
