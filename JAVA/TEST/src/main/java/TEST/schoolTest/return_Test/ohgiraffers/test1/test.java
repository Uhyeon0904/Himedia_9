package TEST.schoolTest.return_Test.ohgiraffers.test1;

public class test {
    // 기본자료형 8개
    public static void main(String[] args) {
        test t = new test();
        t.method1(5,6);
    }
    public void method1(int num1, int num2) {
        byte bnum = 0;
        short snum = 0;
        int inum = 0;
        long lnum = 0;
        double dnum = 0.0;
        float fnum = 0.0f;
        String str = "";
        boolean isTrue = true;

        int result1 = (num1 + num2);
        String result2 = (result1 > 0) ? "양수 입니다." : "음수 입니다.";
        System.out.println(result2);
    }

    // Calculator  +=
    public void Calculator(int first, int second) {
        System.out.println("두 수를 더한 값은 : " + (first += second) + " 입니다.");
        System.out.println("두 수를 뺀 값은 : " + (first -= second) + " 입니다.");
        System.out.println("두 수를 곱한 값은 : " + (first *= second) + " 입니다.");
        System.out.println("두 수를 나눈 몫 값은 : " + (first /= second) + " 입니다.");
        System.out.println("두 수를 나눈 나머지 값은 : " + (first %= second) + " 입니다.");
    }

    // CircleArea
    public void CircleArea(int first) {
        final double pi = 3.14;
        double result = (pi * first * first);
        System.out.println("부피 : " + result);
    }

    // TestRandom
    public static String TestRandom() {
        int result = (int)(Math.random()*10)+1;
        String result2 = ("생성된 난수는 : " + result + " 입니다.");
        return result2;
    }

}
