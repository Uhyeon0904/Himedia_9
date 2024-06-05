package TEST.teamTest.ControlStatement;

import java.util.Scanner;

public class PyeonTEST2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력해 주세요 : ");
        String name = sc.nextLine();
        char ch = name.charAt(0);

        switch (ch) {
            case '김' :
                System.out.println("보조배터리");
                break;
            case '이' :
                System.out.println("텀블러");
                break;
            default :
                System.out.println("꽝");
                break;
        }
    }
}
