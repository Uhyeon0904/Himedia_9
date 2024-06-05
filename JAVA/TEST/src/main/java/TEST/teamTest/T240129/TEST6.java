package TEST.teamTest.T240129;

import java.util.Scanner;

public class TEST6 {
    public static void main(String[] args) {
        TEST6 six = new TEST6();
        six.scanner();
    }

    public void scanner() {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 정수 : ");
        int num1 = sc.nextInt();

        System.out.print("두 번째 정수 : ");
        int num2 = sc.nextInt();

        int plusResult = (num1 + num2);
        System.out.println("합 : " + (num1 + num2));
        System.out.println("차 : " + (num1 - num2));
        System.out.println("곱 : " + (num1 * num2));
        System.out.println("나누기 : " + (num1 / num2));

    }
}
