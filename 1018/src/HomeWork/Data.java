package HomeWork;


import java.util.Arrays;

public class Data {


    private static String[] user = new String[2];

    public void addUser(String name, String password) {
        if (checkUser(name, password)) {
            user[0] = name;
            user[1] = password;
            System.out.println("用户注册成功");
            System.out.println(Arrays.toString(user));
        } else {
            System.out.println("用户名或密码不符合要求");
        }
    }

    public boolean checkUser(String name, String password) {
        if (name.length() < 6 && password.length() < 8) {
            return false;
        }

        /*判断账户是否包含数字和字母*/
        boolean hasLetter = false;
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) hasLetter = true;
        }
        if (!hasLetter) {
            return false;
        }

        /*判断密码是否包含那一大坡*/
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (c == '_' || c == '$') hasSpecial = true;
        }

        if (!hasLower || !hasUpper || !hasSpecial || !hasDigit) {
            return false;
        }

        return true;
    }
}
