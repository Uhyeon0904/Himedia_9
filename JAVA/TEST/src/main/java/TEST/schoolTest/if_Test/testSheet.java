package TEST.schoolTest.if_Test;

import java.util.Scanner;

public class testSheet {
    // 조건문 1
    public void testA() {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이가 어떻게 되세요? ");
        int age = sc.nextInt();

        if (age >= 20) {
            System.out.println("판매 가능합니다.");
        } else {
            System.out.println("판매 불가능합니다 음료 코너에서 골라주세요.");
        }
    }

    // 조건문 2
    public void testB() {

        Scanner sc = new Scanner(System.in);
        System.out.print("당첨 번호가 어떻게 되세요?");
        int num = sc.nextInt();

        if (num % 2 != 0 && num <= 10) {
            System.out.println("홀수네요, 인형 선물입니다!");
        } else if (num % 2 == 0 && num <= 10){
            System.out.println("짝수네요, 모자 선물입니다!");
        } else {
            System.out.println("당첨 번호는 1~10 사이에만 있어요.");
        }
    }

    // 조건문 3
    public void testC() {
        Scanner sc = new Scanner(System.in);

        System.out.print("성실 점수 : ");
        int num1 = sc.nextInt();

        System.out.print("서비스 점수 : ");
        int num2 = sc.nextInt();

        System.out.print("미소 점수 : ");
        int num3 = sc.nextInt();

        int avg = (num1 + num2 + num3) / 3;

        if (avg > 60 && num1 >= 40 && num2 >= 40 && num3 >= 40) {
            System.out.println("합격 입니다!");
            } else {
            if (avg < 60) {
                System.out.println("불합격 입니다...");
            }
            if (num1 < 40) {
                System.out.println("성실 점수 미달입니다");
            }
            if (num2 < 40) {
                System.out.println("서비스 점수 미달입니다");
            }
            if (num3 < 40) {
                System.out.println("미소 점수 미달입니다");
            }
        }
    }

    // 조건문 4
    public void testD() {
        Scanner sc = new Scanner(System.in);

        System.out.print("월 급여 입력 : ");
        int salary = sc.nextInt();

        System.out.print("월 매출 입력 : ");
        int sales = sc.nextInt();

        double bonusRate = 0;
        int bonus = (int)(sales + bonusRate);
        if (sales >= 5000) {
            bonusRate = 0.05;
        } if (sales < 5000 && sales >= 3000) {
            bonusRate = 0.03;
        } if (sales < 3000 && sales >= 1000) {
            bonusRate = 0.01;
        } else {
            bonusRate = 0;
        }
        System.out.println("매출액 : " + sales);
        System.out.println("보너스율 : " + (bonusRate * 100) + "%");
        System.out.println("월 급여 : " + salary);
        System.out.println("보너스 금액 : " + bonus);
        System.out.println("총 급여 : " + (salary + (sales * bonusRate)));
    }
}