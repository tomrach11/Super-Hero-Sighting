package com.tsg.dvdlibrary.dao;

public class DVDLibraryDataValidationException extends Exception {

    public DVDLibraryDataValidationException (String message) {
        super(message);
    }

    public DVDLibraryDataValidationException (String message, Throwable cause) {
        super(message, cause);
    }
}
