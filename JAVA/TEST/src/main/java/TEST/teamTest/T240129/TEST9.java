package TEST.teamTest.T240129;

public class TEST9 {
    public static void main(String[] args) {
        int ran1 = (int)(Math.random() * 100) +1;
        System.out.println("첫 번째 주사위 : " + ran1);

        int ran2 = (int)(Math.random() * 100) +1;
        System.out.println("두 번째 주사위 : " + ran2);

        int result = (ran1 + ran2);
        System.out.println("주사위의 합 : " + result);
    }
}
