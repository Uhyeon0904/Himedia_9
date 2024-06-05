package BAEKJOON.Operator;

import java.util.Scanner;

public class BJ11382 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        double resutl = Math.pow(10, 12);
//        System.out.println((long) resutl);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println((long) (a + b + c));
        sc.close();
    }
}
