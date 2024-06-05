package TEST.teamTest.ControlStatement;

import java.util.Scanner;

public class MyTEST1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            int ran = (int)(Math.random() * 50) + 1;
            if (ran % 3 == 0) {
                sum += ran;
            }
        }
        System.out.println("3의 배수 총 합은 : " + sum);
    }
}
