public class User {
//    2.设计一个User类，其中包括用户名、口令等属性，构造方法(至少重载2个)，
//    获取和设置口令的方法，获取和设置用户名的方法等。

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        User u = new User("xiaohong", "123456");

        System.out.println("username:" + u.getUsername() + "\npassword:" + u.getPassword());
    }
}
