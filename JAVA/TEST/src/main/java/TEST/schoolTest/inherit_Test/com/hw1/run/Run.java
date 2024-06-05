package TEST.schoolTest.inherit_Test.com.hw1.run;

import TEST.schoolTest.inherit_Test.com.hw1.model.dto.Employee;
import TEST.schoolTest.inherit_Test.com.hw1.model.dto.Student;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        for (Student student : students) {
            System.out.println(student.information());
        }

        System.out.println("=========================================================================================");

        Employee[] employees = new Employee[2];
        Scanner sc = new Scanner(System.in);

        int count = 0;
        while (true) {
            System.out.println();
            System.out.print("정보를 추가 하겠습니까? Y/N> ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                if (count >= employees.length) {
                    System.out.println("정보를 추가할 수 없습니다.");
                    break;
                }
                System.out.print("이름 : ");
                String name = sc.nextLine();
                System.out.print("나이 : ");
                int age = sc.nextInt();
                System.out.print("신장 : ");
                double height = sc.nextDouble();
                System.out.print("몸무게 : ");
                double weight = sc.nextDouble();
                System.out.print("급여 : ");
                int salary = sc.nextInt();
                System.out.print("부서 : ");
                String major = sc.next();
                sc.nextLine();
                employees[count] = new Employee(name, age, height, weight, salary, major);
                count++;
            }else {
                System.out.print("정보를 추가하지 않습니다.");
                System.out.println();
                break;
            }
        }
        for (Employee employee : employees) {
            System.out.println(employee.information());
        }

        System.out.println("=========================================================================================");
    }
}
