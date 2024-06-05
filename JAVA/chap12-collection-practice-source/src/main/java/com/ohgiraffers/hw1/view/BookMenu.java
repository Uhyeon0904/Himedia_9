package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {
    Scanner sc = new Scanner(System.in);

    BookManager bm = new BookManager();

    public BookMenu() {}

    public void mainMenu() {

        while (true) {
            System.out.println("=== 도서 관리 프로그램 ===");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서정보 정렬 후 출력");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 검색출력");
            System.out.println("5. 전체출력");
            System.out.println("6. 끝내기");
            System.out.println("=======================");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1 : bm.addBook(inputBook());
                    break;
                case 2 :
//                    bm.printBook(selectSortedBook());
                    break;
                case 3 : bm.deleteBook(inputBookNo());
                    break;
                case 4 : bm.searchBook(inputBookTitle());
                    break;
                case 5 : bm.displayAll();
                    break;
                case 6 :
                    System.out.println("프로그램을 종료 합니다.");
                    return;
                default:
                    return;
            }
        }
    }

    public BookDTO inputBook() {
        System.out.print("도서 번호 : ");
        int bNo = sc.nextInt();
        sc.nextLine();
        System.out.print("도서 제목 : ");
        String title = sc.next();
        System.out.print("도서 장르 > 1:인문 / 2:자연과학 / 3:의료 / 4:기타 : ");
        int category = sc.nextInt();
        System.out.print("도서 저자 : ");
        String author = sc.next();

        BookDTO bookDTO = new BookDTO(bNo, title, category, author);

        return bookDTO;
    }

    public int inputBookNo() {
        System.out.print("삭제할 도서 번호 : ");
        int remove = sc.nextInt();
        return remove;
    }

    public String inputBookTitle() {
        System.out.print("검색할 도서 제목 : ");
        String title = sc.nextLine();
        return title;
    }

//    public List<BookDTO> selectSortedBook(Comparator<BookDTO> comparator) {}
}
