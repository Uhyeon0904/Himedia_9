package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args) {
//        System.out.println(); 출력 명령어
        System.out.println(123);
        System.out.println(1.23);
        System.out.println('A'); // 문자 형태의 값은 혼따옴표(single-quotation)으로 감싸야 한다
//        System.out.println('AB'); // 두 개 이상은 문자로 취급하지 않기 때문에 에러
//        System.out.println(''); // 아무 문자도 기록되지 않은 경우도 에러
        System.out.println('1'); // 숫자 값 이지만 홀다옴표로 감싸져 있는 경우 문자 1이라고 판단
        System.out.println("안녕하세요"); // 문자열은 문자 여러개가 나열된 형태를 말하며 쌍다옴표(double-quotation)으로 감싸주어야 한다
        System.out.println("123"); // 정수 이지만 쌍따옴표로 감싸져있기 때문에 문자열로 본다
        System.out.println(""); // 아무 값도 없는 빈 쌍따옴표도 문자열로 취급한다.
        System.out.println("C"); // 한 개의 문자도 쌍따옴표로 감싸면 문자열이다.
        System.out.println(true);
        System.out.println(false); // true 또는 false 값을 논리형이라고 한다
    }
}
