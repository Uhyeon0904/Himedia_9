package TEST.teamTest.ControlStatement;

import java.util.Scanner;

public class SonTEST2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("년도를 입력해 주세요 : ");
        int year = sc.nextInt();

        switch (year) {
            case 2000 :
                System.out.println(2000 + "년도의 태생은 용띠 입니다.");break;
            case 2001 :
                System.out.println(2001 + "년도의 태생은 뱀띠 입니다.");break;
            case 2002 :
                System.out.println(2002 + "년도의 태생은 말띠 입니다.");break;
            default:
                System.out.println("해당 년도는 없습니다.");
        }

    }
}
