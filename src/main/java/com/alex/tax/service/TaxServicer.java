package com.alex.tax.service;

import java.util.List;

import com.alex.tax.exceptions.InvalidTaxRateException;
import com.alex.tax.model.OutputTaxModel;

public interface TaxServicer {
    public OutputTaxModel getTaxRate(String state) throws InvalidTaxRateException;
    public List<OutputTaxModel> getAllTaxRates();
}
