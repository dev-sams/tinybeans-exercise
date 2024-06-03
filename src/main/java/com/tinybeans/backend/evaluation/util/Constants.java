package com.tinybeans.backend.evaluation.util;


import org.springframework.http.HttpStatus;

public class Constants {
    public static final Integer STATUS_SUCCESS = HttpStatus.OK.value();
    public static final Integer STATUS_BAD_REQUEST = HttpStatus.BAD_REQUEST.value();
    public static final Integer STATUS_NOT_FOUND = HttpStatus.NOT_FOUND.value();
    public static final Integer STATUS_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final Integer STATUS_CREATED = HttpStatus.CREATED.value();
}
