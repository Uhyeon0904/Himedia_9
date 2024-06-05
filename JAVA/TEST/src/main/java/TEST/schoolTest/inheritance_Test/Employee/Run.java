package TEST.schoolTest.inheritance_Test.Employee;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Student[] student = new Student[3];
        student[0] = new Student("홍길동", 20, 178.2
                , 70.0, 1, "정보시스템공학과");

        student[1] = new Student("김말똥", 21, 187.3
                , 80.0, 2, "경영학과");

        student[2] = new Student("강개순", 23, 167.0
                , 45.0, 4, "정보통신고학과");
        // student

        Employee employee = new Employee();
        System.out.println(employee);
        Employee employee1 = new Employee("박보검", 26, 180.3
                , 72.0, 100000000, "영업부");
        Employee employee2 = new Employee("강동원", 38, 182.0
                , 76.0, 200000000, "기획부");
        // employee


        for (Student i : student) {
            System.out.println(i);
        }

        Scanner sc = new Scanner(System.in);
        Employee[] employeeArr = new Employee[10];
        int count = 0;

        while (true) {
            System.out.print("계속 추가할 것인가요? (Y/N) : ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                if (count > employeeArr.length) {
                    System.out.println("추가할 공간이 없습니다.");
                    break;
                }
                System.out.print("이름 : ");
                String name = sc.nextLine();

                System.out.print("나이 : ");
                int age = sc.nextInt();

                System.out.print("키 : ");
                double height = sc.nextDouble();

                System.out.print("몸무게 : ");
                double weight = sc.nextDouble();

                System.out.print("급여 : ");
                int salary = sc.nextInt();;

                sc.nextLine();

                System.out.print("기획부 : ");
                String dept = sc.nextLine();

                employeeArr[count] = new Employee(name, age, height, weight, salary, dept);
                count += 1;

            }else {
                System.out.println("추가를 하지 않습니다.");
                break;
            }
            System.out.println();
        }
            for (int i = 0; i < count; i++) {
                System.out.println(employeeArr[i]);
                System.out.println();
            }
    }
}
