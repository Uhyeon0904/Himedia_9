package BAEKJOON.Array;

import java.util.Scanner;

public class BJ10807 {
    public static void main(String[] args) {

        int[] arr;

        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 개수 : ");
        int arrEA = sc.nextInt();
        arr = new int[arrEA];

        System.out.print("찾을 숫자 : ");
        int searchNum = sc.nextInt();

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int random = (int)(Math.random() * 100) + 1;
            arr[i] = random;
            System.out.println("정수 : " + random + " ");
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == searchNum) {
                count++;
            }
        }
        System.out.println(searchNum + "(은)는 " + count + "개 입니다.");
    }
}
