package TEST.schoolTest.if_Test;

import java.util.Scanner;

public class testSheet3 {
    public void testC() {
        Scanner sc = new Scanner(System.in);

        System.out.print("성실 : ");
        int sincerity = sc.nextInt();

        System.out.print("서비스 : ");
        int service = sc.nextInt();

        System.out.print("미소 : ");
        int smile = sc.nextInt();

        int add = (sincerity + service + smile) / 3;

        if (add > 59) {

        }
    }
}
