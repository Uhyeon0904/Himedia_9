package BAEKJOON.ConditionalStatement;

import java.util.Scanner;

public class BJ2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        sc.close();

        if (m + t >= 60 && h >= 24) {
            h = 0;
            h++;
            m = (m + t) - 60;
            if (m >= 60) {
                h++;
                m = m - 60;
            }
            System.out.println(h + " " + m);
        }else {
            System.out.println(h + " " + (m + t));
        }
    }
}
