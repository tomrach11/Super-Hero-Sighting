package com.tr.addressbook.ui;

import com.tr.addressbook.dao.AddressBookDaoException;

public interface UserIO {

    void print(String message);

    void println(String message);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max) throws AddressBookDaoException;

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max) throws AddressBookDaoException;

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);

}
