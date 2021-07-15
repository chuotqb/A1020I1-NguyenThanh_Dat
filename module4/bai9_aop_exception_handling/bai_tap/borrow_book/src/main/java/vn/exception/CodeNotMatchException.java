package vn.exception;

public class CodeNotMatchException extends Exception{
    @Override
    public String getMessage(){
        return "Code not match";
    }
}
