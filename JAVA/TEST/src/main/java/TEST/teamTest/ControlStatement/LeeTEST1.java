package TEST.teamTest.ControlStatement;

import java.util.Scanner;

public class LeeTEST1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int danSu = 0;
        for (int dan = 2; dan <= 9; dan++) {
            for (int su =1; su <= 9; su++) {
                System.out.print(dan + " * " + su + " = " + (dan * su) + "\t");
            }
            System.out.println();
        }
    }
}
