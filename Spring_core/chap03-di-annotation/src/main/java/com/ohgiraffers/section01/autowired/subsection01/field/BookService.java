package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service: @Component의 세분화 어노테이션의 한 종류로 Service 계층에서 사용한다. */
@Service("bookServiceField")
public class BookService {

    /* BookDAO 타입과 일치하는 bean이 있다면, 자동으로 등록한다.*/
    /* BookDAO 타입의 bean 객체를 이 프로퍼티에 자동으로 주입해 준다.*/
    /* type을 통한 의존성 주입 */
    /* 필드 주입 방식 */
    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
