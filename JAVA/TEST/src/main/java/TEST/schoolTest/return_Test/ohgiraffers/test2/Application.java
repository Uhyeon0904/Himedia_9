package TEST.schoolTest.return_Test.ohgiraffers.test2;

import TEST.schoolTest.return_Test.ohgiraffers.test1.test;
public class Application {
    public static void main(String[] args) {

        test t = new test();

        t.Calculator(10,20);

        t.CircleArea(5);

        String ran = t.TestRandom();
        System.out.println(ran);
    }
}
