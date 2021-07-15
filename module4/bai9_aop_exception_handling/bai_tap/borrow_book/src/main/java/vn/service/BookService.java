package vn.service;

import vn.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(int id);

    void delete(int id);

    void borrow(Book book,int usedCode);

    boolean returnBook(Book book, int usedCode);
}
