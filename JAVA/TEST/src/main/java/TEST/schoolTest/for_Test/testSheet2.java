package TEST.schoolTest.for_Test;

import java.util.Scanner;

public class testSheet2 {
    public void testA() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 : ");
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("합 : " + sum);
    }

    public void testB() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 : ");
        int num = sc.nextInt();
        String sum = "";
        String str1 = "토";
        String str2 = "마";

        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) {
                sum += str1;
            }else {
                sum += str2;
            }
        }
        System.out.print(sum);
        sc.close();
    }

    public void testC() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 : ");
        int num = sc.nextInt();

        for (int i = 0; ; i++) {
            int randomNumber = (int)(Math.random()*100)+1;
            if (num > randomNumber) {
                System.out.println("정수가 난수보다 큽니다.");
            }else if (num < randomNumber) {
                System.out.println("정수가 난수보다 작습니다.");
            }else {
                System.out.println("정답 " + i + "회 만에 맞추셨습니다.");
                break;
            }
        }
    }
}
