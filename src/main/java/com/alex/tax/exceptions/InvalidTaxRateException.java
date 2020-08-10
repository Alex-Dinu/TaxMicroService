package com.alex.tax.exceptions;

public class InvalidTaxRateException extends Exception{

    public InvalidTaxRateException(){}

    public InvalidTaxRateException(String message) {
        super(message);
    }
}
