package Practice1;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Rock> rocks = new HashSet<>();

        rocks.add(new Rock("xiaohei"));
        rocks.add(new Rock("dabai"));
        rocks.add(new Rock("mingming"));
        rocks.add(new Rock("honghong"));
        rocks.add(new Rock("dongdong"));

        Iterator<Rock> iterator = rocks.iterator();
        while (iterator.hasNext()) {
            Rock next = iterator.next();
            System.out.println(next);
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