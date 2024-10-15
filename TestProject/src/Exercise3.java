import java.util.Scanner;

/**
 * PACKAGE_NAME.Exercise1
 * User: hly
 * Date: 2024/10/09 14:29
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class Exercise3 {
    public static void main(String[] args) {
        //定义控制台输入对象
        Scanner scanner = new Scanner(System.in);
        //提示语句
        System.out.println("请输入第一个数:");
        //接收第这个数
        double num1 = scanner.nextDouble();
        //四舍五入
        int number = (int) (num1 * 100);// 整型 包含了后面两位数
        //小数点的第三位数
        int three = (int) (num1 * 1000) % 10;
        //判断四舍五入
        number = three >= 5 ? number + 1 : number;
        //结果
        double result = number / 100.0;
        System.out.println(num1 + "四舍五入之后是:" + result);//23.4567

    }
}
