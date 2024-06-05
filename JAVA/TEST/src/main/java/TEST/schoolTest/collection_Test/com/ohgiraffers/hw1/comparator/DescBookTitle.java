package TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.comparator;

import TEST.schoolTest.collection_Test.com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Comparator;

public class DescBookTitle implements Comparator<BookDTO> {
    @Override

    public int compare(BookDTO o1, BookDTO o2) {
        return o2.getTitle().compareTo(o1.getTitle());
    }
}
