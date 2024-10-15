import java.util.Scanner;

/**
 * PACKAGE_NAME.Exercise1
 * User: hly
 * Date: 2024/10/09 14:29
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class Exercise2 {
    public static void main(String[] args) {
        //定义控制台输入对象
        Scanner scanner = new Scanner(System.in);
        //提示语句
        System.out.println("请输入第一个数:");
        //接受第一个数
        int num1 = scanner.nextInt();
        //提示语句
        System.out.println("请输入第二个数:");
        //接收第二个数
        int num2 = scanner.nextInt();
        //提示语句
        System.out.println("请输入第三个数:");
        //接收第三个数
        int num3 = scanner.nextInt();
        // 找出 1和2 之间最大值
        int max = num1 > num2 ? num1 : num2;
        // 找出最大值和 3之间谁大 大值赋值给max
        max = max > num3 ? max : num3;
        //得出结论输出
        System.out.println("您输入的最大值为:" + max);

    }
}
