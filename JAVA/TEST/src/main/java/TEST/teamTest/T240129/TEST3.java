package TEST.teamTest.T240129;

public class TEST3 {
    public static void main(String[] args) {
        circleArea(3.14, 5, 5);
        circleRound(2, 3.14, 5);
    }

    public static void circleArea(double pi1, int radius1, int radius2) {
        double result = (pi1 * radius1 * radius2);
        System.out.println("원의 넓이 : " + result);
    }

    public static void circleRound(int num, double pi2, int radius3) {
        double result = (num * pi2 * radius3);
        System.out.println("원의 둘레 : " + result);
    }
}
