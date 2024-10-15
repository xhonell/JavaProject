/**
 * PACKAGE_NAME.Test10
 * User: hly
 * Date: 2024/10/09 14:38
 * motto:   逆水行舟不进则退
 * Description:  条件运算符   三元运算符  三目运算符
 * Version: v1.0
 */
public class Test11 {
    public static void main(String[] args) {
        //                  条件运算符 语法
        System.out.println(true ? 1 : 2);
        //定义变量
        int a = 14, b = 13, c;
        //求两数值之间的最大值
        c = a > b ? a : b;//如果a>b是true 那么把a的值赋值给c 如果a>b是false 那么把b的值赋值给c
        //求出 三个数之间的最大值
        System.out.println(c);
        c = 24;
        //找出ab最大的
        int max = a > b ? a : b;
        //ab最大的与c比较
        max = max > c ? max : c;

    }
}
