package BAEKJOON.Array;

import java.util.Arrays;
import java.util.Scanner;

public class BJ10818  {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("배열 입력 > ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
//            int random = ((int) (Math.random() * 1000)) + 1;
//            arr[i] = random;
            System.out.print("정수 입력 > ");
            arr[i] = sc.nextInt();
//            System.out.print(arr[i] + " ");
        }
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[n - 1]);
    }
}
