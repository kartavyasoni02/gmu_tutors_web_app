package controllers;

/**
 * Created by Andrew on 4/22/2017.
 */
public enum ErrorCode {
    GENERAL_ERROR(1000, "A general error has occurred"),
    INTERNAL_ERROR(1002, "An error occurred which we were unable to resolve"),
    REQUEST_MESSAGE_NOT_READABLE(1021, "Request body is empty or contains invalid JSON"),
    MEDIA_TYPE_NOT_SUPPORTED(1022, "Request has unsupported content-type"),
    REQUEST_METHOD_NOT_SUPPORTED(1023, "Request method not supported"),
    REQUEST_PARAMETER_IS_MISSING(1024, "Request parameter is missing"),
    REQUEST_PARAMETER_INVALID(1025, "Request parameter is invalid"),
    PATH_PARAMETER_INVALID(1026, "Path parameter is invalid"),
    VALIDATION_FAILED(2000, "Problems validating"),
    INVALID_INPUT(2001, "The information supplied was invalid"),
    DUPLICATE_ENTITY(2002, "A duplicate entity was detected"),
    INVALID_ENTITY(2010, "You have requested non-existent information"),
    INVALID_EXT_ID(2011, "The identifier passed was invalid"),
    AUTHENTICATION_FAILED(3001, "Authentication failed"),
    NOT_PERMITTED(3002, "You do not have access to this data"),
    REMOTE_SYSTEM_ERROR(5001, "An error occurred in a remote system");


    private int code;
    private String message;

    ErrorCode(int i, String s) {
        this.code = i;
        this.message = s;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
