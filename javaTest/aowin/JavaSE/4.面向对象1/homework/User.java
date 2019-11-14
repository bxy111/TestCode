//4. 定义一个网络用户类User，要处理的信息有用户ID,用户密码，email地址, 包含方法show
//        (显示基本信息，在控制台显示id,密码,email地址)

public class User {
    private int id;
    private String password;
    private String email;

    public User(int id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public void show() {
        System.out.print("id:" + id);
        System.out.print(" password:" + password);
        System.out.print(" email:" + email);
    }

    public static void main(String[] args) {
        User u = new User(1, "123456", "23123131311@qq.com");
        u.show();
    }
}
