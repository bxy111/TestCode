package Practice4;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> stringHashMap = new HashMap<>();

        stringHashMap.put("浙江", "杭州");
        stringHashMap.put("安徽", "合肥");
        stringHashMap.put("江苏", "南京");
        stringHashMap.put("山东", "济南");
        stringHashMap.put("福建", "福州");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入省份名称:");
        String next = scanner.next();

        String s = stringHashMap.get(next);
        if (s == null) {
            System.out.println("没有这个省份的信息");
        } else {
            System.out.println(s);
        }
    }
}
