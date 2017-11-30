package com.cwoongc.sbsetting.api.user.exception;



public class UserServiceException extends RuntimeException {

    private static final String MSG_PREFIX = "[" + UserServiceException.class.getName().replace("Exception","") + "]";

    public UserServiceException(String msg) { super(MSG_PREFIX + msg);}

    public UserServiceException(Throwable cause) { super(MSG_PREFIX, cause); }

    public UserServiceException(String message, Throwable exception) {
        super(MSG_PREFIX + message, exception);
    }

    
}
