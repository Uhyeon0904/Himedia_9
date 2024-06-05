package BAEKJOON.Operator;
import java.util.Scanner;
public class BJ25304 {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int sum = 0;
                int x = sc.nextInt();
                int n = sc.nextInt();

                for(int i = 0; i < n; i++) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    sum += a * b;
                }
                if(x == sum) {
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
        sc.close();
    }
}
