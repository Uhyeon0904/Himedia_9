package TEST.teamTest.T240129;

import java.util.Scanner;

public class TEST4 {
    public static void main(String[] args) {
        TEST4 four = new TEST4();
        four.minMaxFinder();
    }

    public void minMaxFinder() {

        Scanner sc = new Scanner(System.in);

//        System.out.print("첫 번째 값 : ");
//        int num1 = sc.nextInt();
//
//        System.out.print("두 번째 값 : ");
//        int num2 = sc.nextInt();
//
//        System.out.print("세 번째 값 : ");
//        int num3 = sc.nextInt();

//        int max = Math.max(50, 80, 20);
//        int min = Math.min(50, 80, 20);

        System.out.println("최대값 : " + Math.max(50, Math.max(80,20)));
        System.out.println("최소값 : " + Math.min(50,Math.min(80,20)));

    }
}
