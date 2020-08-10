package com.alex.tax.service.taxrates;

public class IllinoisTaxRate implements TaxRater{

    static final double STATE_TAX = 12.5;
    @Override
    public double getTaxRate() {
        return STATE_TAX;
    }

}
