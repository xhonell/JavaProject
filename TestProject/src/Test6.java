/**
 * PACKAGE_NAME.Test6
 * User: hly
 * Date: 2024/10/09 10:52
 * motto:   逆水行舟不进则退
 * Description: 数据类型之间的相互转换
 * Version: v1.0
 */
public class Test6 {
    public static void main(String[] args) {
        // 最小的  字节型
        byte b = 12;
        //定义整型
        int a;
        //把b的数值赋值给a
        a = b;//把12给a  可以直接复制 隐式转换 类型(小转大)
        //反过来  a的值赋值给b (大转小)
        a = 13;
        b = (byte) a;//强转
        //定义一个char
        char c = 65;//定义十进制数值来代表对应的字符
        System.out.println(c);
        //定义变量
        int i = 12;
        float f = i;
        //更换值
        f = 12.3F;//必须带单位
        double d = f;
        d = 23.9;
        f = (float) d;// f=d;//错
        i = (int) d;// i=d;//错  直接取整数部分省略小数
        System.out.println(i);//23
        d = 2 - 1.1;
        System.out.println(d);


    }
}
