package com.ohgiraffers.hw1.comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Comparator;

public class DescBookTitle implements Comparator<BookDTO> {
    public int compare(BookDTO b1, BookDTO b2) {
        return b2.getTitle().compareTo(b1.getTitle());
    }
}
