package BAEKJOON.ConditionalStatement;

import java.util.Scanner;

public class BJ2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();

        if (y >= 1 && y <= 4000) {
            if (y % 4 == 0) {
                if (y % 100 != 1 && y % 400 == 0){
                    System.out.println("1");
                }else {
                    System.out.println("0");
                }
            }
        }
        sc.close();
    }
}
