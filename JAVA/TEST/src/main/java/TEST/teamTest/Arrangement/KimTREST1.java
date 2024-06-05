package TEST.teamTest.Arrangement;

public class KimTREST1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i+1]) {
                System.out.println("배열 안에 중복된 숫자가 없습니다.");
            } else {
                System.out.println("배열 안에 중복된 숫자가 있습니다.");
                break;
            }
        }
    }
}
