package BAEKJOON.Array;

import java.util.Scanner;

public class BJ2562 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("배열 입력 > ");
        int arrNum = sc.nextInt();

        int[] arr = new int[arrNum];

        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print("정수 입력 > ");
            System.out.println(arr[i] = sc.nextInt());
            if (arr[i] > max) {
                max = arr[i];
                count = i + 1;
            }
        }
        System.out.println("최댓값: " + max + "(은)는 " + count + "번째 수 입니다.");

//        Arrays.sort(arr);
//        int maxIndex = arrNum - 1;
//        System.out.println("최댓값: " + arr[arr.length - 1] + "(은)는 " + maxIndex + "번째 수 입니다.");
    }
}
