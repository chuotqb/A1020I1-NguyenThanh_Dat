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

    @ManyToOne(targetEntity = CodeBook.class)
    @JoinColumn(name = "book_id")
    private Book book;
}
