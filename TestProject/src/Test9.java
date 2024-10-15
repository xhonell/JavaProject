/**
 * PACKAGE_NAME.Test9
 * User: hly
 * Date: 2024/10/09 14:34
 * motto:   逆水行舟不进则退
 * Description: 比较 运算符  正确或者错误  true false
 * Version: v1.0
 */
public class Test9 {
    public static void main(String[] args) {
        // 定义变量
        int a = 12, b = 13, c = 13;
        boolean tf = a > b;
        System.out.println(tf);//F
        tf = a < b;
        System.out.println(tf);//T
        tf = a <= b;
        System.out.println(tf);//T
        tf = c == b;
        System.out.println(tf);//T
        tf = c != b;
        System.out.println(tf);//F

        byte e = 12;
        System.out.println(a == e);//true  false

    }
}
