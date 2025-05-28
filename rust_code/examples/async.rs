#[tokio::main]
async fn main() {
    // let result = tokio::fs::read_to_string("data.txt").await;

    // match result {
    //     Ok(content) => {
    //         println!("file content: {}", content);
    //     }
    //     Err(error) => {
    //         println!("error : {}", error);
    //     }
    // }

    // say_hello().await;

    // println!("=====================");

    // let _ = tokio::spawn(say_hello()).await;

    // let _ = tokio::spawn(async {
    //     println!("ni hao");
    // })
    // .await;

    // tokio::join!(say_hello(), say_goodbye());

    tokio::select! {
        _ = say_hello() => {
            println!("say_hello() completed first")
        }
        _ = say_goodbye() => {
            println!("say_goodbye() completed first")
        }
        _ = tokio::time::sleep(tokio::time::Duration::from_millis(1500)) => {
            println!("time out!");
        }
    };
}

async fn say_hello() {
    tokio::time::sleep(std::time::Duration::from_secs(1)).await;
    println!("Hello world");
}

async fn say_goodbye() {
    tokio::time::sleep(std::time::Duration::from_secs(1)).await;
    println!("good bye");
}
