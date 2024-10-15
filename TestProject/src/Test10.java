/**
 * PACKAGE_NAME.Test10
 * User: hly
 * Date: 2024/10/09 14:38
 * motto:   逆水行舟不进则退
 * Description:  逻辑运算符
 * Version: v1.0
 */
public class Test10 {
    public static void main(String[] args) {
        //定义变量
        int a = 12, b = 13, c = 13;
        //布尔类型       true        12    14 false
        boolean t = a == (--b) & (b++) == (++c);  //a要等于b并且b要等于c 那么结果为true 否则为false
        System.out.println(t);//false
        //    12  12true   12   15false
        t = a == (--b) | b == (++c);  //a要等于b 或者 b要等于c 只要满足一个 结果就是true 除非全部为false结论才是false
        System.out.println(t);//T
        System.out.println(!t);//false
        System.out.println("a=" + a);//12
        System.out.println("b=" + b);//12
        System.out.println("c=" + c);//15
        a = 12;
        b = 13;
        c = 13;
        //短路情况
        //    12 13 false
        t = a == (b--) && (b++) == (++c) && (b++) == (++c);  //&&如果检查到有false 直接得出结果为 false,后面将不再执行
        System.out.println(t);//false
        //   12  12true
        t = a == (b--) || b == (++c);  //a要等于b 或者 b要等于c 检查到true就直接得出true结论后面式子不在执行
        System.out.println(t);//T
        System.out.println(!t);//false
        System.out.println("a=" + a);//12
        System.out.println("b=" + b);//11
        System.out.println("c=" + c);//13
        //一真一假 真   假假 假  真真 假
        System.out.println(true ^ false);//true
        System.out.println(true ^ true);//false
        System.out.println(false ^ false);//false
        System.out.println(true ^ true ^ true);//false^true  true


    }
}
