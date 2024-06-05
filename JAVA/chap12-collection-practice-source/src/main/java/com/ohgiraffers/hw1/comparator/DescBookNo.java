package com.ohgiraffers.hw1.comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Comparator;

public class DescBookNo implements Comparator<BookDTO> {
    @Override
    public int compare(BookDTO b1, BookDTO b2) {
        return Integer.compare(b2.getbNo(), b1.getbNo());
    }
}
