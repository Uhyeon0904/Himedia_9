package BAEKJOON.Operator;

import java.util.Scanner;

public class BJ2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 정수 : ");
        int inum = sc.nextInt();

        System.out.print("두 번째 정수 : ");
        String snum = sc.next();

        int count = 0;
        int sum = 0;
        for (int i = snum.length() - 1; i > 0; i--) {
//            int num = Integer.parseInt(snum);
//            count += inum * snum;
            System.out.println(count);
            sum += count;
        }
        System.out.println(sum);
        sc.close();
    }
}
