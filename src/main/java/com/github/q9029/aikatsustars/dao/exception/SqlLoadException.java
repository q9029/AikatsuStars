package com.github.q9029.aikatsustars.dao.exception;

import java.io.IOException;

public class SqlLoadException extends RuntimeException {

    public SqlLoadException(IOException e) {
        super(e);
    }
}
