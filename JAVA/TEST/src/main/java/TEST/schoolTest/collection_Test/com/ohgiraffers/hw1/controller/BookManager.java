package TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.controller;

import TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.comparator.AscBookNo;
import TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.comparator.AscBookTitle;
import TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.comparator.DescBookNo;
import TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.comparator.DescBookTitle;
import TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {

    List<BookDTO> booklist = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void addBook(BookDTO book) {
        booklist.add(book);
    }

    public void deleteBook(int index) {
        boolean found = false;
        for (int i = 0; i < booklist.size(); i++) {
            BookDTO bookDTO = booklist.get(i);
            if (bookDTO.getbNo() == index) {
                booklist.remove(i);
                System.out.println("해당 도서가 삭제 되었습니다.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("해당 도서가 없어 삭제할 수 없습니다.");
        }
    }

    public void searchBook(String title) {
        boolean found = false;
        for (BookDTO bookDTO : booklist) {
            if (bookDTO.getTitle().contains(title)) {
                System.out.println(bookDTO);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("조회된 도서가 목록에 없습니다.");
        }
    }

    public void displayAll() {
        if (booklist.isEmpty()) {
            System.out.println("조회결과가 없습니다.");
        }else {
            for (BookDTO bookDTO : booklist) {
                System.out.println(bookDTO);
            }
        }
    }

    public List<BookDTO> sortedBookList(int type) {
        switch (type) {
            case 1 :
                booklist.sort(new AscBookNo());
                break;
            case 2 :
                booklist.sort(new DescBookNo());
                break;
            case 3 :
                booklist.sort(new AscBookTitle());
                break;
            case 4 :
                booklist.sort(new DescBookTitle());
                break;
            default :
                System.out.println("올바르지 않은 정렬 방식입니다.");
                return new ArrayList<>();
        }
        return booklist;
    }

    public void printBookList(List<BookDTO> printList) {
        for (BookDTO bookDTO : printList) {
            System.out.println(bookDTO);
        }
    }
}
