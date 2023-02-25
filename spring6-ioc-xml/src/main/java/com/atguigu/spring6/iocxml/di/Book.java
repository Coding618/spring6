package com.atguigu.spring6.iocxml.di;

public class Book {

    private String bname;
    private String author;

    private String others;

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public Book() {
        System.out.println("无参数构造执行了。。。。。。");
    }
    public Book(String bname, String author) {
        System.out.println("有参数构造执行了。。。。。。");
        this.bname = bname;
        this.author = author;
    }

    // 生成setter
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // 原生 set 方法注入
        Book book = new Book();
        book.setBname("Java");
        book.setAuthor("何琪修");
        System.out.println(book);

        // 通过构造器方法 注入
        Book book1 = new Book("C++", "王一博");
        System.out.println(book1);

    }
}
