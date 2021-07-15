package vn.exception;

public class NotBorrowException extends Exception{
    @Override
    public String getMessage(){
        return "This book has been borrowed";
    }
}
