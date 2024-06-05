package BAEKJOON.Array;

import java.util.Random;
import java.util.Scanner;

public class BJ5597 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int[] studentArr = new int[30];

        for (int i = 0; i < studentArr.length; i++) {
            int studentNum = random.nextInt(30) + 1;
            System.out.print(studentNum);
            if (i < studentArr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("출석번호 1 > ");
        int choiceNum1 = sc.nextInt();
        System.out.println();
        System.out.print("출석번호 1 > ");
        int choiceNum2 = sc.nextInt();
    }
}
