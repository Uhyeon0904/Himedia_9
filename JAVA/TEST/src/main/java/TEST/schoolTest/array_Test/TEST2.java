package TEST.schoolTest.array_Test;

import java.util.Scanner;

public class TEST2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[14];
        System.out.print("주민번호 : ");
        String ssnum = sc.nextLine();

        for (int i = 0; i < ssnum.length(); i++) {
            arr[i] = ssnum.charAt(i) + "";
        }
        for (int i = 8; i < ssnum.length(); i++) {
            arr[i] = "*";
        }
        for (int i = 0; i < ssnum.length(); i++) {
            System.out.print(arr[i]);
        }
    }
}
