package TEST.teamTest.T240129;

import java.util.Scanner;

public class TEST7 {
    public static void main(String[] args) {
        TEST7 t = new TEST7();
        t.method1();
    }

    public void method1() {
        Scanner sc = new Scanner(System.in);

        System.out.print("10의 자리 : ");
        int num1 = sc.nextInt();

        System.out.print("1의 자리 : ");
        int num2 = sc.nextInt();

        String same = (num2 == num1)? "같은 숫자 입니다." : "같은 숫자가 아닙니다.";
        System.out.println(same);
    }
}
