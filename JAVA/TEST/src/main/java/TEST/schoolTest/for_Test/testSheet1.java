package TEST.schoolTest.for_Test;

import java.util.Random;
import java.util.Scanner;

public class testSheet1 {
    // 문제 1
    public void testA() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int num1 = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= num1; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("1부터 10가지 짝수의 합 : " + sum);
    }

    // 문제 2
    public void testB() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();

        int i = 1;
        while (i <= num) {
            if (i % 2 != 0) {
                System.out.print("토");
            } else {
                System.out.print("마");
            }i++;
        }
    }

    // 문제 3
    public void testD() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 : ");
        int integer = sc.nextInt();
        Random random = new Random();

        for (int i = 0; ; i++) {
            int randomNumber = (int) (Math.random() * 100) + 1;
            if (randomNumber == integer) {
                System.out.println("정답 입니다. " + i + "회 만에 정답을 맞추셨습니다.");
                break;
            }else if (randomNumber > integer) {
                System.out.println("난수가 정수보다 큽니다.");
            }else {
                System.out.println("정수가 난수보다 큽니다.");
            }
        }
        sc.close();
    }
}
