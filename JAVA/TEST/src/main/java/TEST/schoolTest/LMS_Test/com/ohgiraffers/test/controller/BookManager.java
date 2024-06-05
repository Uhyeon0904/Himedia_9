package TEST.schoolTest.LMS_Test.com.ohgiraffers.test.controller;

import TEST.schoolTest.LMS_Test.com.ohgiraffers.test.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private List<BookDTO> list;

    public BookManager() {
        list = new ArrayList<>();
    }

    public void addBook(BookDTO bookDTO) {
        list.add(bookDTO);
    }

    public void deleteBook(int index) {
        boolean found = false;
        for (BookDTO bookDTO : list) {
            if (bookDTO.getbNo() == index) {
                list.remove(bookDTO);
                System.out.println("해당 도서가 삭제 됐습니다.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("해당 도서가 없어 삭제할 수 없습니다.");
        }
    }

//    public int searchBook(String title) {}

    public  void printBook(int index) {}

    public void displayAll() {}

//    public ArrayList<BookDTO> sortedBookList(int select) {}

    public void printBookList(ArrayList<BookDTO> br) {}
}
