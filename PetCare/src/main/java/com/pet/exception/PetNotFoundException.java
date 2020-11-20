package com.pet.exception;

 

@SuppressWarnings("serial")
public class PetNotFoundException extends RuntimeException {

 

    public PetNotFoundException() {
        // TODO Auto-generated constructor stub
    }

 

    public PetNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

 

    public PetNotFoundException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

 

    public PetNotFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

 

    public PetNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

 

}