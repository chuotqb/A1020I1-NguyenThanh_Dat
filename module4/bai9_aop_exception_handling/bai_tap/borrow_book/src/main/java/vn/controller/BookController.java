package vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.exception.CodeNotMatchException;
import vn.exception.NotBorrowException;
import vn.model.Book;
import vn.model.CodeBook;
import vn.service.BookService;
import vn.service.CodeBookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    CodeBookService codeBookService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("books",bookService.findAll());
        return "book/home";
    }

    @GetMapping("/book/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/book/create")
    public String createBook(Model model, @Validated @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute(book);
            return "book/create";
        }
        bookService.save(book);
        return "redirect:/home";
    }

    @GetMapping("/book/borrow/{id}")
    public String showBorrowBook(@PathVariable("id") int id,Model model) throws NotBorrowException {
        Book book = bookService.findById(id);
        List<CodeBook> codeBooks = codeBookService.findAllByBook_IdAndStatus(id,"available");
        if (codeBooks.isEmpty()){
            throw new NotBorrowException();
        }
        model.addAttribute("book",book);
        model.addAttribute("codeBook",codeBooks.get(0));
        return "book/borrow";
    }

    @PostMapping("/book/borrow")
    public String borrow(@ModelAttribute Book book, @RequestParam("usedCode") int usedCode){
        bookService.borrow(book,usedCode);
        return "redirect:/home";
    }

    @GetMapping("/book/return/{id}")
    public String showReturnBook(@PathVariable("id") int id,Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "book/return";
    }

    @PostMapping("/book/return")
    public String returnBook(@ModelAttribute Book book, @RequestParam("usedCode") int usedCode) throws CodeNotMatchException {
        if (bookService.returnBook(book,usedCode)){
            return "redirect:/home";
        }else {
            throw  new CodeNotMatchException();
        }
    }
    @ExceptionHandler(NotBorrowException.class)
    public String notBorrow(){
        return "/exception/error_not_borrow";
    }

    @ExceptionHandler(CodeNotMatchException.class)
    public String codeNotMatch(){
        return "/exception/error_code_not_found";
    }
}
