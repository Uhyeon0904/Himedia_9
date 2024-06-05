package TEST.schoolTest.operator_Test;

public class TEST6 {
    public static void main(String[] args) {
        int month = 1, day = 16;
        String result = (month <= 6 && day <= 15) ? "배민 쿠폰" : (month >= 7 && day >= 16) ? "스타벅스 커피" : "사탕";
        System.out.println("선물은 " + result + " 입니다.");
    }
}
