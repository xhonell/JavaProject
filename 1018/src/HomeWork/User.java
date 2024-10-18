package HomeWork;

import lombok.Data;

import java.util.Arrays;

@Data
public class User {
    private String userName;
    private String userPassword;
    public static int count = 0;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User() {
    }

    public void register() {
        HomeWork.Data data = new HomeWork.Data();
        data.addUser(this.getUserName(), this.getUserPassword());

    }

}
