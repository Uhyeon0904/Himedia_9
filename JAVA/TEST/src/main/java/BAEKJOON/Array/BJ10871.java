package BAEKJOON.Array;

import java.util.Scanner;

public class BJ10871 {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 : ");
        int n = sc.nextInt();
        for (int i = 0; i < a.length; i++) {
            int random = (int) ((Math.random() * 10) + 1);
            System.out.print(random + " ");
            a[i] = random;
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            if (a[i] < n) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
