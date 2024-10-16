public class Teacher {
    public String name;
    public int age;
    public double height;
    public double weight;
    public boolean sex;
    public String course;

    public void teach() {
        System.out.println(name + "正在教授" + course);
    }

    public void changeWork() {
        System.out.println(name + "正在更在作业");
    }
}
