package BAEKJOON.Loop;

import java.util.Scanner;

public class BJ25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        String literal = "";
        for (int i = 0; i < n / 4; i++) {
            if (n % 4 == 0) {
                literal += "long ";
            }
        }
        System.out.println(literal + "int");
    }
}
