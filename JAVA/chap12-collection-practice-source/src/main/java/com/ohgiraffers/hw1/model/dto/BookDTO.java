package com.ohgiraffers.hw1.model.dto;

public class BookDTO {

    private int bNo;

    private int category;

    private String title;

    private String author;

    public BookDTO() {}

    public BookDTO(int bNo, String title, int category, String author) {
        this.category = category;
        this.author = author;
        this.title = title;
        this.bNo = bNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getbNo() {
        return bNo;
    }

    public void setbNo(int bNom) {
        this.bNo = bNom;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String
     toString() {
        return "BookDTO{" +
                "bNo=" + bNo +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
