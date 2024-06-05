package TEST.schoolTest.array_Test;

import java.util.Scanner;

public class TEST22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = new String[14];

        System.out.print("주민 번호 입력 : " );
        String ssnum = sc.nextLine();
        sc.close();

        for (int i = 0; i < ssnum.length(); i++) {
            strArr[i] = ssnum.charAt(i) + "";
        }

        for (int i = 8; i < strArr.length; i++) {
            strArr[i] = "*";
        }

        for (int i = 0; i < strArr.length; i++) {
            System.out.print(strArr[i]);
        }
    }
}
