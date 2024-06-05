package TEST.schoolTest.object_Test.No1;

public class Application {
    public static void main(String[] args) {
        BookVO book1 = new BookVO();
        System.out.println(book1.printInformation());       // 기본 생성자 초기화

        BookVO book2 = new BookVO("자바의 정석", "도우출판"
                , "남궁성");       // 3가지 초기화 생성자
        System.out.println(book2.printInformation());

        BookVO book3 = new BookVO("홍길동전", "활빈당", "허균",
                5000000, 0.5);      // 모든 필드 초기화 생성자
        System.out.println(book3.printInformation());
    }
}
