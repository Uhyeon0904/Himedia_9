package TEST.schoolTest.array_Test;

import java.util.Scanner;

public class TEST11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] fruits = {"딸기", "바나나", "복숭아", "키위", "사과"};

        System.out.print("정수 : ");
        int num = sc.nextInt();
        if (num >= 0 && num <= fruits.length - 1) {
            System.out.println(fruits[num]);
        }else {
            System.out.println("꽝");
        }
    }
}
