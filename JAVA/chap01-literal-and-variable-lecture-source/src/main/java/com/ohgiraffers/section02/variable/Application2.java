package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args) {
        /* 변수를 사용하는 방법
        1. 변수를 준비한다 ( 선언 )
        2. 변수에 값을 대입한다. ( 값 대입 및 초기화 )
        3. 변수를 사용한다
         */
        // 자료형 변수명

        /* 자료형 이란?
        다양한 값의 형태별로 어느정도 크기를 하나의 값을 취급할 것인지 미리 compiler와 약속한 키워드이다.
        예) 앞에서 사용한 int 자료형은 정수를 4byte만큼 읽어서 하나의 값으로 취급하겠다는 약속이다.
        이러한 자료형은 기본자료형( primary type )과 참조자료형( reference type )으로 나누어진다.
        그 중 기본자료형 8가지 부터 살펴보자
         */

        /* 정수를 취급하는 자료형 4가지 */
        byte bnum; // 1byte
        short snum; // 2byte
        int inum; // 4byte
        long lnum; // 8byte

        /* 실수를 취급하는 자료형 2가지 */
        float fnum; // 4byte
        double dnum; // 8byte

        /* 문자를 취급하는 자료형 1가지 */
        char ch; // 2byte
        char ch2;

        /* 논리 값을 취급하는 자료형 1가지 */
        boolean isTure; // 1byte

        /* 문자열을 취급하는 자료형 */
        String str; // 4byte

        bnum = 1;
        snum = 2;
        inum = 4;
        lnum = 8;
        lnum = 8L;
        // Long 변수는 값을 넣어줄 때 대문자 L을 붙여야 한다.

//        fnum = 4.0;
        fnum = 4.0f;
        dnum = 8.0;
        // 자바는 실수 자료형은 double로 기본설정이 되어있다.
        // float으로 사용하고자 하면 실수 뒤에 f를 붙여 사용한다고 선언해야 된다.
        // 특수한 경우가 아니면 float은 사용하지 않는다

        ch = 'a';
        ch2 = 97;

        isTure = true;
        isTure = false; // true 혹은 false 중 한 가지의 값만 사용 가능하다.

        str = "안녕하세요";

        /* 숫자로 된 형태의 값을 그대로 사용하는 자료형은 byte, short, int, double이 있고
        * 일반적으로 사용하는 값을 독특한 형태가 아닌 일반적인 형태로 사용할 수 있는 자료형을 대표 자료형이라고 하며
        * 정수형은 int, 실수형은 double이 대표 자료형이다.*/

        int point = 100;
        int bonus = 10;

        System.out.println("변수에 저장된 값 출력");
        System.out.println("bonus의 값 : " + bnum);
        System.out.println("sum의 값 : " + snum);
        System.out.println("inum의 값 : " + inum);
        System.out.println("lnum의 값 : " + lnum);

        System.out.println("fnum의 값 : " + fnum);
        System.out.println("dnum의 값 : " + dnum);

        System.out.println("ch의 값 : " + ch);
        System.out.println("ch2의 값 : " + ch2);

        System.out.println("isTrue의 값 : " + isTure);

        System.out.println("str의 값 : " + str);

        System.out.println("포인트와 보너스의 합은?" + ( point + bonus ));

        point = point + 100; // 200
        System.out.println("point = point + 100" + point);


    }
}
