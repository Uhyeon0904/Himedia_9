package TEST.schoolTest.object_Test.No1;

public class BookVO {
    String title;
    String publisher;
    String author;
    int price;
    double discountRate;

    // 기본 생성자 초기화
    public  BookVO(){}

    // 3가지 초기화 생성자
    public BookVO(String title, String publisher, String author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    // 모든 필드 초기화 생성자
    public  BookVO(String title, String publisher,
                            String author, int price, double discountRate) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }

    public void setTitle() {
        this.title = title;
    }

    public void setPublisher() {
        this.publisher = publisher;
    }

    public void setAuthor() {
        this.author = author;
    }

    public void setPrice() {
        this.price = price;
    }

    public void setDiscountRate() {
        this.discountRate = discountRate;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String printInformation() {
        return "[title : " + title + "], [publisher : " + publisher + "], [author : " + author
                + "], [price : " + price + "], [discountRate : " + discountRate + "]";
    }
}
