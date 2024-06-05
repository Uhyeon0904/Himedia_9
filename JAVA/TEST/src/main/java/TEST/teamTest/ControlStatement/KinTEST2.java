package TEST.teamTest.ControlStatement;

public class KinTEST2 {
    public static void main(String[] args) {

        int num = 0;

        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0 && i % 3 != 0) {
                num += i;
            }
        }
        System.out.println("2의 배수와 3의 배수가 아닌 수의 총 합은 : " + num);
    }
}