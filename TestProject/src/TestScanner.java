import java.util.Scanner; //  导包  除开 java.lang 底下的类不需要导包  其他类使用都要导包

/**
 * PACKAGE_NAME.TestScanner
 * User: hly
 * Date: 2024/10/09 15:24
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class TestScanner {
    public static void main(String[] args) {
        //提示语句
        System.out.println("请输入一个整数:");
        //控制台输入对象
        //数据类型  变量名  =赋值;
        Scanner scanner = new Scanner(System.in);
        //调用对象的方法
        int num = scanner.nextInt();//阻塞
        System.out.println(num);
        System.out.println("请输入一个数:");
        double dou = scanner.nextDouble();

    }
}
