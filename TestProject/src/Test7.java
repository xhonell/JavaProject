/**
 * PACKAGE_NAME.Test7
 * User: hly
 * Date: 2024/10/09 11:22
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class Test7 {
    public static void main(String[] args) {
//        //定义变量
//        int  a=12,b=13;
//        int  c=a+b;//25
//        System.out.println(c);
//        c=a/b;
//        System.out.println(c);//0
//        c=a%b;//取余数
//        System.out.println(c);//12
//        //相同类型 做运算
//        //不同类型
//        byte   a1=12;
//        short  a2=13;
//        int   a3=14;
//        double   a4=15;
//        //不同类型进行运算  结果类型一定 该运算中类型最高的
//        double sum=a1/a2+a3-a4;
//
//        //特别的注意事项
//        short  b1=12,b2=13;
//        //
//       // short  b3=b1+b2;//错
//       short  b3=(short)(b1+b2);
//       //++   --
//
        int i = 1;
        ++i;
        System.out.println(i);//2
        i++;
        System.out.println(i);//3
        i--;
        System.out.println(i);//2
        System.out.println("================");
        i = 1;
        int a = ++i;//先自加然后给a赋值
        System.out.println(a);//2
        System.out.println(i);//2
        System.out.println("================");
        i = 1;//重置为1
        int b = i++;//先给b赋值 然后自加
        System.out.println(b);//1
        System.out.println(i);//2
        System.out.println("================");
        i = 1;//重置为1
        //        1    2
        int sum = (i++) + i;
        System.out.println(sum);//3
        System.out.println(i);//2
        System.out.println("================");
        i = 1;//重置为1
        //   1    2  2        4  4
        sum = (i++) + i + (i++) + (++i) + (i++);//++ 在后 遇到下一个i再自加1
        System.out.println(sum);//
        System.out.println(i);//5
        System.out.println("================");
        //精度丢失
        double num = 2 - 1.1;//0.9
        System.out.println(num);//精度丢失
        //
        //int  e=1/0;//报错  0不能做除数
        double result = 1 / 0.0;//0.0  无限接近0
        System.out.println(result);
        String str = "a是的" + "b打分";// String  + 起到拼接作用
        System.out.println(str);
        str = "i=" + i;//String + 任意类型   拼接作用
        System.out.println(str);//i=5


    }
}
