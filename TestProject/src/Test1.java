/**
 * PACKAGE_NAME
 * User: hly
 * Date: 2024/10/09 9:04
 * motto:   逆水行舟不进则退
 * Description:
 * Version: V1.0
 */
class Test2 {
    //修饰符的顺序 可以交换
    static public void main(String aaa[]) {
        //输出打印语句
        System.out.print("不影响");//不换行
        System.out.println("不影响");//换行
        System.out.print("不影响");//不换行
    }

    //static  void  public  main(String []  agrs){
}

public class Test1 {
    //修饰符的顺序 可以交换
    static public void main(String aaa[]) {
        System.out.println("不影响");
    }

    //static  void  public  main(String []  agrs){
}

class Test3 {
    //修饰符的顺序 可以交换
    static public void main(String aaa[]) {
        System.out.println("不影响");
    }

    //static  void  public  main(String []  agrs){
}
