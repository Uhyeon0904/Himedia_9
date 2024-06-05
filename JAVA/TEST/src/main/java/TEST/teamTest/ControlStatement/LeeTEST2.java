package TEST.teamTest.ControlStatement;

import java.util.Scanner;

public class LeeTEST2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("학년 : ");
        int num = sc.nextInt();

        System.out.print("점수 : ");
        int score = sc.nextInt();

        if (score > 0 && score < 101) {
            if (num >= 4 && score >= 70) {
                System.out.println("합격 입니다");
            } else if (num >= 4 && score < 70) {
                System.out.println("불합격 입니다");
            } else if (num < 4 && score >= 60){
                System.out.println("합격 입니다");
            } else if (num < 4 && score < 60){
                System.out.println("불합격 입니다.");
            }
        }  else {
            System.out.println("잘못된 점수 입니다.");
        }
    }
}
