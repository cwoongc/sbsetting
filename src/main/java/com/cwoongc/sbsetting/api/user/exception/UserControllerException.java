package com.cwoongc.sbsetting.api.user.exception;



public class UserControllerException extends RuntimeException {

    private static final String MSG_PREFIX = "[" + UserControllerException.class.getName().replace("Exception","") + "]";

    public UserControllerException(String msg) { super(MSG_PREFIX + msg);}

    public UserControllerException(Throwable cause) { super(MSG_PREFIX, cause); }

    public UserControllerException(String message, Throwable exception) {
        super(MSG_PREFIX + message, exception);
    }

    
}
