package controllers;

/**
 * Created by Andrew on 4/21/2017.
 *
 * Exception class used by the exception handler
 */
public final class SpringException extends RuntimeException{
    private String message;

    public SpringException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
