package TEST.teamTest.T240129;public class TEST1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        TEST1 test = new TEST1();
        test.plus();
    }

    public void plus() {
        System.out.println("더하기 : " + (10 + 20));
        minus();
    }

    public void minus() {
        System.out.println("빼기 : " + (20 - 10));
        multiple();
    }

    public void multiple() {
        System.out.println("곱하기 : " + (10 * 20));
        divide();
    }

    public void divide() {
        System.out.println("나누기 : " + (20 / 10));
    }
}
