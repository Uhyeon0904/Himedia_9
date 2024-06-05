package BAEKJOON.Operator;

import java.util.Scanner;

public class BJ15552 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, a, b;
        int sum = 0;
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            sum += a + b;
        }
        System.out.println(sum);
        sc.close();
    }
}
