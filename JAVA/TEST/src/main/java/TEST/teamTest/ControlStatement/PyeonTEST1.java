package TEST.teamTest.ControlStatement;

import java.util.Scanner;

public class PyeonTEST1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단어를 입력해주세요 : ");
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i -1)){
                System.out.println("뒤집었을 때 같은 단어가 아닙니다.");
                break;
            } if (i == str.length() - 1){
                System.out.println("뒤집었을 때 같은 단어 입니다.");
            }
        }
    }
}
