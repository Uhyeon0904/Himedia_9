package TEST.schoolTest.inheritance_Test.Employee;

public class Employee extends Person{
    private int salary;
    private String dept;

    public Employee(){
    }

    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(age, weight, height);
        this.dept = dept;
        this.salary = salary;
        super.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String information(String name, int age, double height, double weight
            , int salary, String dept) {
        return super.information() + "[ 급여 : " + salary + "], [ 부서 : " + dept + "]";
    }

    @Override
    public String toString() {
        return information();
    }
}