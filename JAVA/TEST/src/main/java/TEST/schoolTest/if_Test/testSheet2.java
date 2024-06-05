package TEST.schoolTest.if_Test;

import java.util.Scanner;

public class testSheet2 {
    public static void testA() {
        Scanner sc = new Scanner(System.in);

        System.out.println("나이는? : ");
        int age = sc.nextInt();

        if (age > 19) {
            System.out.println("판매 가능");
        } else {
            System.out.println("판매 불가능");
        }
    }

    public static void testB() {
        Scanner sc = new Scanner(System.in);

        System.out.print("당첨 번호 : ");
        int winningNumber = sc.nextInt();

        if (winningNumber < 11 && winningNumber > 0) {

            if (winningNumber % 2 != 0) {
                System.out.println("홀수");
            }else {
                System.out.println("짝수");
            }
        }else {
            System.out.println("꽝");
        }
    }
}
