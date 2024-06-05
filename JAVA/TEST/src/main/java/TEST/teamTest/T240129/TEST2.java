package TEST.teamTest.T240129;

public class TEST2 {
    public static void main(String[] args) {
        A(31);
    }

    public static void A(int num) {
        String result = (num % 2 == 0) ? "짝수" : "홀수";
        System.out.println("숫자 " + num + "(은)는 " + result + "다");
    }
}
