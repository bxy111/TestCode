package Practice2;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Rock> rocks = new Stack<>();

        Rock one = new Rock("one");
        Rock two = new Rock("two");
        Rock three = new Rock("three");

        rocks.push(one);
        rocks.push(two);
        rocks.push(three);

        rocks.pop();
        rocks.pop();

        rocks.push(three);
        while (!rocks.isEmpty()) {
            System.out.println(rocks.pop());
        }
    }
}

class Rock {
    private String name;

    public Rock(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rock{" +
                "name='" + name + '\'' +
                '}';
    }
}
