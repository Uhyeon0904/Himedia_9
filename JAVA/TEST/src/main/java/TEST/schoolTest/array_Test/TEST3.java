package TEST.schoolTest.array_Test;

public class TEST3 {
    public static void main(String[] args) {
        int [] rotto = new int[6];

        for (int i = 0; i < 6; i++) {
            rotto[i] = (int)(Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) {
                if (rotto[i] == rotto[j]) {
                    i--;
                }
            }
            System.out.print(rotto[i] + " ");
        }
    }
}