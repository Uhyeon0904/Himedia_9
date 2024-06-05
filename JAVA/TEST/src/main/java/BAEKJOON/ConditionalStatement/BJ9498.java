package BAEKJOON.ConditionalStatement;

import java.util.Scanner;

public class BJ9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int scores = sc.nextInt();

        if (scores >= 0 && scores <= 100) {
            if (scores >= 90) {
                System.out.println("A");
            }else if (scores >= 80) {
                System.out.println("B");
            }else if (scores >= 70) {
                System.out.println("C");
            }else if (scores >= 60) {
                System.out.println("D");
            }else {
                System.out.println("F");
            }
        }
        sc.close();
    }
}
