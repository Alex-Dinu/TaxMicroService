package com.alex.tax.service.taxrates;

public class FloridaTaxRate implements TaxRater{

    static final double STATE_TAX = 6.5;
    @Override
    public double getTaxRate() {
        return STATE_TAX;
    }

}
