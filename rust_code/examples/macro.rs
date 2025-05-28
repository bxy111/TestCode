// macro_rules! say_hello {
//     () => {
//         println!("hello");
//     };
//     ($name:expr) => {
//         println!("hello, {}!", $name);
//     };
// }

macro_rules! nameof {
    ($name:ident) => {
        stringify!($name)
    };
}
fn main() {
    // say_hello!("xiaoming");
    // say_hello!();

    println!("{}", nameof!(b));

    let a = nameof!(Person);
    println!("{}", a);
}
