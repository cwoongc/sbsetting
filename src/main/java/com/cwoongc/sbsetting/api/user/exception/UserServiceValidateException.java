package com.cwoongc.sbsetting.api.user.exception;



public class UserServiceValidateException extends RuntimeException {

    private static final String MSG_PREFIX = "[" + UserServiceValidateException.class.getName().replace("Exception","") + "]";

    public UserServiceValidateException(String msg) { super(MSG_PREFIX + msg);}

    public UserServiceValidateException(Throwable cause) { super(MSG_PREFIX, cause); }

    public UserServiceValidateException(String message, Throwable exception) {
        super(MSG_PREFIX + message, exception);
    }

    
}
