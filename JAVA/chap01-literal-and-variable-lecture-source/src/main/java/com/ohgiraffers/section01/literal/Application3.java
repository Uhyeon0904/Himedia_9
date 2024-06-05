package com.ohgiraffers.section01.literal;

public class Application3 {
    public static void main(String[] args) {
        System.out.println("두 개의 문자열 합치기");
        System.out.println(9 + 9); // 정수 18
        System.out.println("9" + 9); // 문자 99
        System.out.println(9 + "9"); // 문자 99
        System.out.println("9" + "9"); // 문자 99
        // 문자열이 연산에 들어가면 출력 값은 문자열로 나온다

        System.out.println("세개의 문자열 합치기");
        System.out.println(9 + 9 + "9"); // 189
        System.out.println(9 + "9" + 9); // 999
        System.out.println("9" + 9 + 9); // 999

        System.out.println("9" + (9 + 9)); // 918
        // 괄호를 사용하면 괄호부터 연산을 한다.

        System.out.println("10과 20의 사칙연산 결과");
        System.out.println(10 + 20);
        System.out.println(10 - 20);
        System.out.println(10 * 20);
        System.out.println(10 / 20);
        System.out.println(10 % 20);

        System.out.println("10과 20의 사칙연산 결과 보기 좋게 출력");
        // 괄호를 먼저 연산하고 앞의 문자열을 연산하여 보기 좋게 응용하여 결과 값을 출력한다.
        System.out.println("10과 20의 합 :" + (10 + 20)); // 10과 20의 합 : 30
//        System.out.println("10과 20의 합 :" + 10 + 20); 합이 30이 나오지 않는다
        System.out.println("10과 20의 차 :" + (10 - 20)); // 10과 20의 차 : -10
//        System.out.println("10과 20의 차 :" + 10 - 20); 문자열에서의 빼기는 연산이 불가능하여 에러
        System.out.println("10과 20의 곱 :" + (10 * 20));
        System.out.println("10과 20의 나누기 몫 :" + (10 / 20));
        System.out.println("10과 20의 나누기 나머지 :" + (10 % 20));

        System.out.println("기차");
        System.out.println("기차" + "칙칙폭폭");
        System.out.println("기차" + 123 + 45 + "출발");
        System.out.println(123 + 45 + "기차" + "출발");

    }
}
