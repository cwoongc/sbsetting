package com.cwoongc.sbsetting.api.user.exception;



public class UserControllerValidateException extends RuntimeException {

    private static final String MSG_PREFIX = "[" + UserControllerValidateException.class.getName().replace("Exception","") + "]";

    public UserControllerValidateException(String msg) { super(MSG_PREFIX + msg);}

    public UserControllerValidateException(Throwable cause) { super(MSG_PREFIX, cause); }

    public UserControllerValidateException(String message, Throwable exception) {
        super(MSG_PREFIX + message, exception);
    }

    
}
