package TEST.schoolTest.array_Test;

public class TEST_CARD {
        /*
        카드 뽑기
        1. 문자열 배열에 SPADE, CLOVER, HEART, DIAMOND 를 저장
        2. 문자열 배열에 2, 3, 4, 5, 6, 7, 8, 9, 10, JACK, QUEEN, KING, ACE 를 저장
        3. 1번과 2번 배열의 길이에 맞도록 난수를 각각 발생시킨다.
        4. 위에서 발생시킨 난수를 활용하여 카드를 출력한다.

        출력예시
        당신이 뽑은 카드는 DIAMOND 9 카드 입니다.
         */

    public static void main(String[] args) {
        String[] cardPatten = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] cardNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

        int randomPatten = (int) (Math.random() * 4);
        int randomNumber = (int) (Math.random() * 13);
        String resultPatten = null;
        String resultNumber = " ";

        resultPatten = cardPatten[randomPatten];
        resultNumber = cardNumber[randomNumber];

        System.out.println("당신이 뽑은 카드는 " + resultPatten + " " + resultNumber + " 입니다.");
    }
}
