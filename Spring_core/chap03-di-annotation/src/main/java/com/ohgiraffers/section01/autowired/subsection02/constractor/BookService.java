package com.ohgiraffers.section01.autowired.subsection02.constractor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    /* 생성자 주입 방법을 많이 사용한다.
    *  final 키워드를 사용 할 수 있다는 장점*/
    private final BookDAO bookDAO;

    /* BookDAO 타입의 빈 객체를 생성자에 자동으로 주입해 준다. */
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
