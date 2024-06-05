package TEST.schoolTest.operator_Test;

public class TEST4 {
    public static void main(String[] args) {
        double score1 = 90.0;
        int score2 = (int)score1;
        String result = (score2 >= 90) ? "A" : (score2 >= 80) ? "B" : (score2 >= 70) ? "C" : (score2 >= 60) ? "D" : "F";
        System.out.println("홍길동의 이번 점수 등급은 " + result + " 입니다.");
    }
}
