package TEST.teamTest.ControlStatement;

import java.util.Scanner;

public class KimTEST1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();

        if (num >= 50) {
            System.out.println("50 이상의 수 입니다.");
        } else {
            System.out.println("50 미만의 수 입니다.");
        }
    }

}
