package TEST.teamTest.T240126;

public class TEST1 {
    public static void main(String[] args) {
        int age = 20;
        String result = (age >= 20) ? "성인" : (age >= 17 && age <= 19) ? "고등학생" : (age >= 14 && age <= 16) ? "중학생"
                : (age >= 8 && age <= 13) ? "초등학생" : "미취학";
        System.out.println(result + " 입니다.");
    }
}
