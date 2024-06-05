package com.ohgiraffers.hw1.comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Comparator;

public class AscBookTitle implements Comparator<BookDTO> {
    @Override
    public int compare(BookDTO b1, BookDTO b2) {
        return b1.getTitle().compareTo(b2.getTitle());
    }
}
