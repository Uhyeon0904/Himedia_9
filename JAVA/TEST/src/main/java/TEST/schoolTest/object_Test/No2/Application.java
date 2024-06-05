package TEST.schoolTest.object_Test.No2;

public class Application {
    public static void main(String[] args) {
        BookVO bookVO1 = new BookVO();
        System.out.println(bookVO1);

        BookVO bookVO2 = new BookVO("자바의 정석", "도우출판", "남궁성");
        System.out.println(bookVO2);

        BookVO bookVO3 = new BookVO("자바의 정석", "도우출판", "남궁성", 500000, 0.5);
        System.out.println(bookVO3);
    }
}
