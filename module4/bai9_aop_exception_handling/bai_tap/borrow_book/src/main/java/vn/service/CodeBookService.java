package vn.service;

import vn.model.Book;
import vn.model.CodeBook;

import java.util.List;

public interface CodeBookService {
    List<CodeBook> findAll();

    void save(CodeBook codeBook);

    CodeBook findById(int id);

    void delete(int id);

    List<CodeBook> findCodeBookByBook_Id(int id);
    List<CodeBook> findAllByBook_IdAndStatus(int id,String status);
    CodeBook findByBook_IdAndCode(int id,int codeBook);
}
