package TEST.teamTest.T240129;

public class TEST5 {
    public static void main(String[] args) {
        TEST5 five = new TEST5();
        five.average(79,64,98);
        five.totalScore(79,64,98);
    }

    public void totalScore(int num1, int num2, int num3) {
        int result = (num1 + num2 + num3);
        System.out.println("총점 : " + result);
    }
    public void average(int num1, int num2, int num3) {
        double result = ((double) (num1 + num2 + num3) / 3);
        System.out.println("평균 : " + result);
    }
}
