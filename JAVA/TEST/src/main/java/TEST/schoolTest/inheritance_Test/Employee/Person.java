package TEST.schoolTest.inheritance_Test.Employee;

public class Person extends Run{
    protected String  name;
    private int age;
    private double height;
    private double weight;

    public Person(){}
    public Person(int age, double weight, double height){
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String information() {
        return "[ 이름 : " + name + "], [ 나이 : " + age + "], [ 신장 : " + height
                + "], [ 몸무게 : " + weight + "]";
    }
}