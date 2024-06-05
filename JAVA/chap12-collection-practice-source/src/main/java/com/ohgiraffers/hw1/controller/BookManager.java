package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    public BookManager() {}
    List<BookDTO> booklist = new ArrayList<>();

    public void addBook(BookDTO book) {
        booklist.add(book);
    }

    public void deleteBook(int index) {
        boolean found = false;
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getbNo() == index) {
                booklist.remove(i);
                found = true;
                break;
            }
            if (found) {
                System.out.println("해당 도서가 삭제 됐습니다.");
            }else {
                System.out.println("해당 도서를 찾을 수 없습니다.");
            }
        }
    }

    public void searchBook(String title) {
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getTitle().contains(title)) {
                System.out.println(booklist);
            }else {
                System.out.println("조회된 도서가 목록에 없습니다.");
            }
        }
    }

    public void displayAll() {
        if (booklist.isEmpty()) {
            System.out.println("출력결과 없습니다");
        }
        for (BookDTO bookDTOList : booklist) {
            System.out.println(bookDTOList);
        }
    }

//    public List<BookDTO> sortedBookList() {}

    public void printBook(List<BookDTO> printList) {

    }
}
