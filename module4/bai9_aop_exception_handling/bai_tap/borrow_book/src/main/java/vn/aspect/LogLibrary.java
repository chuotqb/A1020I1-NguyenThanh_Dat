package vn.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogLibrary {
    private int numOfVisitor=0;
    @Pointcut("within(vn.controller.BookController)")
    public void AllMethodPointCut(){}

    @AfterReturning("execution(* vn.controller.BookController.create(..))")
    public void createNewBook(){
        System.out.println("Đã thêm một sách mới vào thư viện vào lúc: " + LocalDate.now());
    }

    @AfterReturning("execution(* vn.controller.BookController.borrow(..))")
    public void borrowBook(){
        System.out.println("Đã mượn một sách vào lúc: " + LocalDate.now());
    }

    @AfterReturning("execution(* vn.controller.BookController.returnBook(..))")
    public void returnBook(){
        System.out.println("Đã trả một sách vào lúc: " + LocalDate.now());
    }

    @AfterThrowing("execution(* vn.controller.BookController.showBorrowBook(..))")
    public void notBorrow(){
        System.out.println("Xảy ra lỗi hết sách để mượn vào lúc: " + LocalDate.now());
    }

    @AfterThrowing("execution(* vn.controller.BookController.returnBook(..))")
    public void codeNotMatch(){
        System.out.println("Xảy ra lỗi nhập code trả sách vào lúc: " + LocalDate.now());
    }


    @AfterReturning("AllMethodPointCut()")
    public void numOfVisitor(){
        numOfVisitor++;
        System.out.println("Số người ghé thăm thư viện: "+ numOfVisitor);
    }

}
