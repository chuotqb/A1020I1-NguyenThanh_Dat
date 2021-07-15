package vn.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
public class CodeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Range(min = 10000,max = 99999)
    private int code;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private String status;

    public CodeBook() {
    }

    public CodeBook(int code, Book book, String status) {
        this.code = code;
        this.book = book;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
