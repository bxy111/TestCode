package Practice4;

import java.io.Serializable;

public class Member implements Serializable {
    private String name;
    private String password;
    private transient String sex;
    private String address;

    public Member(String name, String password, String sex, String address) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
