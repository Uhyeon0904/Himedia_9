package TEST.schoolTest.array_Test;

public class TEST33 {
    public static void main(String[] args) {
        int[] iArr = new int[6];

        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr.length; j++) {
                int random = (int)(Math.random() * 45) + 1;
                if (iArr[i] == random) {
                    break;
                }
                iArr[i] = random;
            }
            System.out.print(iArr[i] + " ");
        }
    }
}
