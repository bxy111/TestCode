import java.util.Scanner;

public class Practice5 {
    static Node[][] nodes = {
            {new Node("哈尔滨", "t1"), new Node("沈阳", "t1"),
                    new Node("北京", "t2"), new Node("杭州", "t3"),
                    new Node("贵阳", "t3"), new Node("深圳", null)},
            {new Node("哈尔滨", "t1"), new Node("沈阳", "t1"),
                    new Node("北京", "t1"), new Node("长沙", "t3"),
                    new Node("杭州", "t3"), new Node("贵阳", "t3"),
                    new Node("深圳", null)},
            {new Node("哈尔滨", "t1"), new Node("沈阳", "t1"),
                    new Node("北京", "t3"), new Node("长沙", "t3"),
                    new Node("杭州", "t3"), new Node("贵阳", "t3"),
                    new Node("深圳", null)},
            {new Node("哈尔滨", "t1"), new Node("沈阳", "t1"),
                    new Node("北京", "t1"), new Node("长沙", "t1"),
                    new Node("南京", null)},
            {new Node("哈尔滨", "t1"), new Node("沈阳", "t1"),
                    new Node("北京", "t3"), new Node("长沙", "t1"),
                    new Node("南京", null)},
            {new Node("哈尔滨", "t2"), new Node("大连", "t2"),
                    new Node("石家庄", "t2"), new Node("北京", "t2"),
                    new Node("杭州", "t3"), new Node("贵阳", "t3"),
                    new Node("深圳", null)},
            {new Node("哈尔滨", "t2"), new Node("大连", "t2"),
                    new Node("石家庄", "t2"), new Node("北京", "t1"),
                    new Node("长沙", "t3"), new Node("杭州", "t3"),
                    new Node("贵阳", "t3"), new Node("深圳", null)},
            {new Node("哈尔滨", "t2"), new Node("大连", "t2"),
                    new Node("石家庄", "t2"), new Node("北京", "t3"),
                    new Node("长沙", "t3"), new Node("杭州", "t3"),
                    new Node("贵阳", "t3"), new Node("深圳", null)},
            {new Node("哈尔滨", "t2"), new Node("大连", "t2"),
                    new Node("石家庄", "t2"), new Node("北京", "t1"),
                    new Node("长沙", "t1"), new Node("南京", null)},
            {new Node("哈尔滨", "t2"), new Node("大连", "t2"),
                    new Node("石家庄", "t2"), new Node("北京", "t3"),
                    new Node("长沙", "t1"), new Node("南京", null)}
    };
    static private String[] t1 = {"哈尔滨", "沈阳", "北京", "长沙", "南京"};
    static private String[] t2 = {"哈尔滨", "大连", "石家庄", "北京", "杭州"};
    static private String[] t3 = {"北京", "长沙", "杭州", "贵阳", "深圳"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入车次:");
        String num = sc.next();
        if (num.equalsIgnoreCase("t1")) {
            for (String s : t1) {
                System.out.print(s + " ");
            }
            System.out.println();
        } else if (num.equalsIgnoreCase("t2")) {
            for (String s : t2) {
                System.out.print(s + " ");
            }
            System.out.println();
        } else if (num.equalsIgnoreCase("t3")) {
            for (String s : t3) {
                System.out.print(s + " ");
            }
            System.out.println();
        } else {
            System.out.println("输入的车次, 没有路线数据, 程序退出。");
            System.exit(-1);
        }

        System.out.println("请输入出发城市和到达城市:");
        String src = sc.next();
        String dst = sc.next();
        searchInNodes(src, dst);
    }

    public static void searchInNodes(String src, String dst) {
        boolean isExistRoute = false;
        Info[] infos = new Info[10];
        int index = 0;
        for (int i = 0; i < nodes.length; i++) {
            int srcIndex = -1, dstIndex = -1;
            for (int j = 0; j < nodes[i].length; j++) {
                if (nodes[i][j].getName().equals(src)) {
                    //找到起点
                    srcIndex = j;
                }
                if (nodes[i][j].getName().equals(dst)) {
                    //找到终点
                    dstIndex = j;
                }
            }
            if (dstIndex > srcIndex && srcIndex != -1) {
                isExistRoute = true;
                //有符合的区间, 获取路线图
                String path = "";
                for (int j = srcIndex; j <= dstIndex; j++) {
                    if (j != dstIndex) {
                        path += (nodes[i][j].getName() + "\t->\t");
                    } else {
                        path += nodes[i][j].getName();
                    }
                }
                //获取车次
                String oldNum = "";
                String numList = "";
                for (int j = srcIndex; j < dstIndex; j++) {
                    if (!oldNum.equals(nodes[i][j].getNum())) {
                        numList += (nodes[i][j].getNum() + "\t");
                        oldNum = nodes[i][j].getNum();
                    }
                }
                boolean isNeedAdd = true;
                for (int j = 0; j < index; j++) {
                    if (infos[j].getPath().equals(path) && infos[j].getNumList().equals(numList)) {
                        isNeedAdd = false;
                    }
                }
                if (isNeedAdd) {
                    infos[index++] = new Info(path, numList);
                    System.out.println("路线图:");
                    System.out.println(path);
                    System.out.println();
                    System.out.println("车次:");
                    System.out.println(numList);
                    System.out.println();
                } else {
                    continue;
                }
            }
        }
        if (!isExistRoute) {
            System.out.println("找不到合适的线路和车次。");
        }
    }
}

class Info {
    private String path;
    private String numList;

    public Info(String path, String numList) {
        this.path = path;
        this.numList = numList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNumList() {
        return numList;
    }

    public void setNumList(String numList) {
        this.numList = numList;
    }
}

class Node {
    private String name;
    private String num;

    public Node(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
