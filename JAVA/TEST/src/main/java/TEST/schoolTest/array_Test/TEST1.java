package TEST.schoolTest.array_Test;

import java.util.Scanner;

public class TEST1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fruits = {"딸기", "바나나", "복숭아", "키위", "사과"};

        System.out.print("0부터 4까지 정수를 입력하세요 : ");
        int integerNum = sc.nextInt();

        if (integerNum >= 0 && integerNum <= fruits.length - 1) {
            System.out.print(fruits[integerNum]);
        }else {
            System.out.println("준비된 과일이 없습니다.");
        }
    }
}
