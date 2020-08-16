package com.alex.tax.repository;

import java.util.List;

import com.alex.tax.model.OutputTaxModel;

public interface TaxGetter {
    public double getTaxRate(String state);
    public List<OutputTaxModel> getAllTaxRates();
}