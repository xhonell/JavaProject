/**
 * PACKAGE_NAME.Test5
 * User: hly
 * Date: 2024/10/09 10:24
 * motto:   逆水行舟不进则退
 * Description:  定义变量
 * Version: v1.0
 */
public class Test5 {
    public static void main(String[] args) {
        //整型
        //数据类型 变量名
        byte _a = -128;
        //数据类型 变量名=数值;
        short s = 120;
        int i = 12;
        long l = 2147483648L;//超过int范围必须带L
        // 进制转换
        float f = 1.72f;
        double dou = 134645.9;
        boolean tf = true;//false
        char c = '男';
        //打印输出c的数值
        System.out.println(c);
        c = '女';//可以再次赋值
        //打印输出c的数值
        System.out.println(c);
        //定义八进制的数
        int aa = 010;//0要定义八进制的数值
        System.out.println(aa);//8
        aa = 0x10;//0要定义八进制的数值
        System.out.println(aa);//16
        //引用数据类型  String
        String str = "任意内容";
        System.out.println(str);

    }
}
