package TEST.schoolTest.inheritance_Test.Employee;

public class Student extends Person{
    private int grade;
    private String major;

    public Student() {
        super();
    }

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, weight, height);
        super.name = name;
        this.major = major;
        this.grade = grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public String getMajor() {
        return major;
    }

    public String information() {
        return  super.information() + "[ 학년 : " + grade + "], [ 정보 : " + major + "]";
    }

    @Override
    public String toString() {
        return information();
    }
}
