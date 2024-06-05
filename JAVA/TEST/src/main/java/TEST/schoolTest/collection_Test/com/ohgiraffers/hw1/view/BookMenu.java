package TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.view;

import TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.controller.BookManager;
import TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.List;
import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);

    BookManager bm = new BookManager();

    public BookMenu() {}

    public void mainMenu() {

        while (true) {
            System.out.println("==========메뉴==========");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 전체 조회");
            System.out.println("5. 도서 정렬 조회");
            System.out.println("0. 프로그램 종료");
            System.out.println("========================");

            System.out.print("메뉴 선택 > ");
            int choiceNumber = sc.nextInt();

            switch (choiceNumber) {
                case 1 :
                    bm.addBook(inputBook());
                    break;
                case 2 :
                    bm.deleteBook(inputBookNo());
                    break;
                case 3 :
                    bm.searchBook(inputBookTitle());
                    break;
                case 4 :
                    bm.displayAll();
                    break;
                case 5 :
                    bm.printBookList(selectSortedBook());
                    break;
                case 0 :
                    return;
                default:
                    return;
            }
        }
    }

    public BookDTO inputBook() {
        System.out.print("도서 번호 > ");
        int bNo = sc.nextInt();

        System.out.print("도서 카테고리 > ");
        sc.next();
        System.out.print("1. 인문 / 2. 자연과학 / 3. 의료 / 4. 기타 > ");
        int category = sc.nextInt();

        System.out.print("도서 제목 > ");
        String title = sc.next();

        System.out.print("도서 저자 > ");
        String author = sc.next();

        return new BookDTO(bNo, category, title, author);
    }

    public int inputBookNo() {
        System.out.print("삭제할 도서 번호 > ");
        return sc.nextInt();
    }

    public String inputBookTitle() {
        System.out.print("검색할 도서 제목 > ");
        return sc.next();
    }

    public List<BookDTO> selectSortedBook() {
        System.out.println("정렬 방식 선택");
        System.out.print("1. 번호 오름차순 / 2. 번호 내림차순 / 3. 제목 오름차순 / 4. 제목 내림차순 > ");
        int sortType = sc.nextInt();
        return bm.sortedBookList(sortType);
    }
}
