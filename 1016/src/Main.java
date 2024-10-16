import org.junit.Test;

import java.util.Random;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    @Test
    public void personTest() {
        /*创建person的实体类*/
        Persons person = new Persons("xhonell", 21, "男");
        System.out.println(person);
    }

    /**
     * 测试类：测试Teacher的使用
     */
    @Test
    public void teacherTest() {
        Teacher teacher = new Teacher();
        teacher.name = "黄丽晔";
        teacher.age = 18;
        teacher.sex = false;
        teacher.course = "Java";

        teacher.changeWork();
        teacher.teach();
    }

    /**
     * 测试类：测试计算圆形的面积以及周长
     */
    @Test
    public void circleTest() {
        Circle circle = new Circle(3);
        System.out.println("圆的面积：" + circle.area());
        System.out.println("圆的周长：" + circle.perimeter());
    }

    /**
     * 测试类：测试Computer类的方法
     */
    @Test
    public void computerTest() {
        Computer computer = new Computer(1.3, 2.0);
        System.out.println("两数相除：" + computer.div());
        System.out.println("两数相乘：" + computer.mul());
        System.out.println("num1是否大小于num2：" + computer.judge());
    }

    /**
     * 测试类：测试工人的总工资
     */
    /*@Test
    public void workerTest() {
        Worker worker = new Worker();
        Worker worker2 = new Worker("xhonell", 21, 23.2);
        System.out.println("总工资：" + worker2.getSalary() * worker2.work(14));

    }*/

    /**
     * 测试类：测试Card类,打印输出牌的花色和点数
     */
    @Test
    public void cardTest() {
        double rand = Math.random();
        int num = (int) (rand * 13);
        Card card = new Card("♠", num);
        card.showCard();
    }

    /**
     * 测试类：写一个类Complex，用来表示复数。
     * 这个复数类具有两个属性：double real，表示实部；double im，表示虚部。
     * 并为Complex 类增加add、sub、mul 方法，分别表示复数的加法、减法和乘法运算。
     */
    @Test
    public void complexTest() {
        Complex c1 = new Complex(3, 5);
        Complex c2 = new Complex(4, 6);

        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("c1 + c2: " + c1.add(c2));
        System.out.println("c1 - c2: " + c1.sub(c2));
        System.out.println("c1 * c2: " + c1.mul(c2));
        System.out.println("c1 + 2.0: " + c1.add(2.0));
    }

    /**
     * 文本输出类：这是一个针对第九题的文本
     * class ClassA{
     * int value;
     * }
     * public class TestClassA{
     * public static void main(String args[]){
     * int value = 10;
     * changeInt(value);//不改变外部值
     * System.out.println(value);//10
     * ClassA ca = new ClassA();
     * ca.value = 10;
     * changeObject(ca);改变外部值
     * System.out.println(ca.value);
     * }
     * public static void changeInt(int value){
     * value++;
     * }
     * public static void changeObject(ClassA ca){
     * ca.value++;
     * }
     * }
     */
    @Test
    public void txtTest() {
        System.out.println("ChangInt = 10,ChangeObject = 11");
    }

    /**
     * 测试类：测试工人的地址
     */
    @Test
    public void workerAddressTest() {
        Address address = new Address("北京市海淀区清华园1 号", "100084");
        Worker worker = new Worker("zhangsan", 25, 2500, address);
        System.out.println(worker.toString());

    }

    /**
     * 文本输出类：这是一个针对第14题的文本
     */
    @Test
    public void QuestionTextFor14(){
        System.out.println("changValue = 100, changeRef = 200");
    }
}

