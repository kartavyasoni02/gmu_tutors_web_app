package controllers;

import java.util.UUID;

/**
 * Created by Andrew on 4/21/2017.
 *
 * Exception class used by the exception handler
 */
public final class SpringException extends RuntimeException{
    private String uniqueId = UUID.randomUUID().toString();
    private int errorCode;
    private String errorName;
    private String errorMessage;

    public SpringException(ErrorCode errorCode, String errorMessage){
        super(errorMessage);
        this.errorName = errorCode.name();
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorMessage;
    }
    public SpringException(ErrorCode errorCode, String errorMessage, Throwable throwable){
        super(errorMessage, throwable);
        this.errorName = errorCode.name();
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorMessage;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "SpringException{" +
                "uniqueId='" + uniqueId + '\'' +
                ", errorCode=" + errorCode +
                ", errorName='" + errorName + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
