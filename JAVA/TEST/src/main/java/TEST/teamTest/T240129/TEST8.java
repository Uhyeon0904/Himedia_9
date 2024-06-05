package TEST.teamTest.T240129;

import java.util.Scanner;

public class TEST8 {
    public static void main(String[] args) {
        TEST8 t = new TEST8();
        t.method1();
    }

    public void method1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("받은 금액 : " + " 원 입니다.");
        int money = sc.nextInt();
    }
}
