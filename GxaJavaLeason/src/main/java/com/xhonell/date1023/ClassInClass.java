package com.xhonell.date1023;

/**
 * day6.ClassInClass
 * User: hly
 * Date: 2024/10/23 14:02
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class ClassInClass {
    public Integer age;
    public   ClassInClass(){}
    //公开内部类
    public  class Stu extends Object{
        public   String  name;
        public   void   test(){
            System.out.println(age);
            System.out.println(name);
           // System.out.println(sex);
            System.out.println(Tea.a);
        }
    }
    //公开的静态内部类
    static public  class Tea{
        public   char  sex;
        static  int   a=12;
    }
    //抽象的内部类
    abstract  public  class Super{ }
    public   class  Sub extends Super{ }

    public static void main(String[] args) {
        //先创建外部类对象
        ClassInClass  classInClass=new ClassInClass();
        //匿名内部类
        Super  s=classInClass.new Super() {};

        //然后利用外内对象去创建内部类的对象
        Stu  stu=classInClass.new  Stu();//公开的内部类的创建方式
        //静态的内部类的创建方式?
        Tea  tea=new  Tea();
        //匿名内部类
        Number number=new Number() {// 匿名子类
            @Override
            public void a() {//重写抽象方法
                System.out.println("a");
            }
        };
        //局部内部类  方法里面
        class  Cat{
            public   int   age;
        }
        Cat  cat=new Cat();
        cat.age=1;
        //匿名内部类
        AI  ai=new AI() {
            @Override
            public void am() {
                System.out.println("am");
            }
        };

    }
}
abstract  class Number{
    abstract  public   void  a();
    public  void   b(){
        System.out.println("b");
    }

}
interface   AI{
    void  am();
}
