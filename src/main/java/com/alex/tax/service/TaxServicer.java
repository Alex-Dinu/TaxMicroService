package com.alex.tax.service;

import com.alex.tax.exceptions.InvalidTaxRateException;
import com.alex.tax.model.OutputTaxModel;

public interface TaxServicer {
    public OutputTaxModel getTaxRate(String state) throws InvalidTaxRateException;
}
