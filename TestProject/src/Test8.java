/**
 * PACKAGE_NAME.Test8
 * User: hly
 * Date: 2024/10/09 14:14
 * motto:   逆水行舟不进则退
 * Description: 赋值运算符
 * Version: v1.0
 */
public class Test8 {
    public static void main(String[] args) {
        //定义变量
        int i = 1234;//=  给i赋值为12
        i += 4;//i=i+4; 进行简写
        System.out.println("i=" + i);//利用String的拼接效果
        i -= 3;
        i *= 2;
        i /= 4;//整型÷整型=整型 26/4=6
        i %= 5;
        System.out.println("i=" + i);//利用String的拼接效果
        //byte +byte=int  short +short =int
        //例外
        byte b = 1;
        //b=b+12;
        b += 12;//b=b+12;隐式强制转换
        System.out.println("i=" + i);//利用String的拼接效果


    }
}
