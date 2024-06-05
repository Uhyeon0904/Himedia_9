package TEST.schoolTest.LMS_Test.com.ohgiraffers.test.view;

import TEST.schoolTest.LMS_Test.com.ohgiraffers.test.controller.BookManager;
import TEST.schoolTest.LMS_Test.com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);

    BookManager bm = new BookManager();

    public BookMenu() {}

    public void menu() {

        while (true) {
            System.out.println("============메뉴============");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("============================");

            System.out.print("메뉴 선택 > ");
            int choiceNumber = sc.nextInt();

            switch (choiceNumber) {
                case 1:
                    bm.addBook(intputBook());
                    break;
                case 2:
                    System.out.print("삭제할 도서 번호 > ");
                    int deleteNumber = sc.nextInt();
                    bm.deleteBook(deleteNumber);
                    break;
                case 3:
//                    bm.searchBook(inputBookTitle());
                    break;

            }
        }
    }

    public BookDTO intputBook() {
        System.out.print("도서 번호 > ");
        int bNo = sc.nextInt();
        System.out.println("카테고리");
        System.out.print("1. 인문 / 2. 자연과학 / 3. 의료 / 4. 기타 > ");
        int category = sc.nextInt();
        System.out.print("도서 제목 > ");
        String title = sc.next();
        System.out.print("도서 저자 > ");
        String author = sc.next();

        return new BookDTO(bNo, category, title, author);
    }

    public String inputBookTitle() {
        System.out.print("검색할 도서 제목 > ");
        return sc.next();
    }
}
