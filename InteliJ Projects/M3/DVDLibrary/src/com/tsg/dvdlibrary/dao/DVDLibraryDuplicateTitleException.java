package com.tsg.dvdlibrary.dao;

public class DVDLibraryDuplicateTitleException extends Exception {

    public DVDLibraryDuplicateTitleException (String message) {
        super(message);
    }

    public DVDLibraryDuplicateTitleException (String message, Throwable cause) {
        super(message, cause);
    }
}
