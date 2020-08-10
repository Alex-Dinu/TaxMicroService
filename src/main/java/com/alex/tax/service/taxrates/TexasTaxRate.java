package com.alex.tax.service.taxrates;

public class TexasTaxRate implements TaxRater{

    static final double STATE_TAX = 7.5;
    @Override
    public double getTaxRate() {
        return STATE_TAX;
    }

}
