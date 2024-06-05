package BAEKJOON.Loop;

import java.util.Scanner;

public class BJ2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 1 && n <= 9) {
            for (int i = 1; i < 10; i++) {
                int sum = n * i;
                System.out.println(n + " * " + i + " = " + sum);
            }
        }
        sc.close();
    }
}
