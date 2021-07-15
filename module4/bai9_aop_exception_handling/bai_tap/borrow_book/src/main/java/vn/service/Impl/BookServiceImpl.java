package vn.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.model.Book;
import vn.model.CodeBook;
import vn.repository.BookRepository;
import vn.repository.CodeBookRepository;
import vn.service.BookService;
import vn.service.CodeBookService;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CodeBookService codeBookService;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
        for (int i = 0;i<book.getQuatity();i++){
//            int n = new Random().nextInt(100000);
            int n = 10000 + new Random().nextInt(90000);
            CodeBook codeBook = new CodeBook(n,bookRepository.findById(book.getId()).orElse(null),"available");
            book.generateCode(codeBook);
            codeBookService.save(codeBook);
        }
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void borrow(Book book, int usedCode) {
        CodeBook codeBook = codeBookService.findByBook_IdAndCode(book.getId(),usedCode);
        Book book1 = bookRepository.findById(book.getId()).orElse(null);
        if (codeBook == null || book1 == null){
            return;
        }
        codeBook.setStatus("using");
        codeBookService.save(codeBook);
       book1.borrow();
       bookRepository.save(book1);
    }

    @Override
    public boolean returnBook(Book book, int usedCode) {
       List<CodeBook> codeBookList = codeBookService.findAllByBook_IdAndStatus(book.getId(),"using");
       Book book1 = bookRepository.findById(book.getId()).orElse(null);
       if (codeBookList.isEmpty()||book1==null){
           return false;
       }
       boolean check = false;
       for (CodeBook codeBook: codeBookList){
           if (codeBook.getCode()==usedCode){
               check=true;
               codeBook.setStatus("available");
               codeBookService.save(codeBook);
           }
       }
       if (check){
           book1.returnBook();
           bookRepository.save(book1);
           return true;
       }else {
           return false;
       }

    }
}
