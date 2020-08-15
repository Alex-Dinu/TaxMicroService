package com.alex.tax.service.taxrates;

import com.alex.tax.repository.TaxGetter;

import org.springframework.beans.factory.annotation.Autowired;

public class IllinoisTaxRate implements TaxRater{

    
    // @Autowired
    // private TaxGetter taxGetter;

    @Override
    public double getTaxRate() {
        //return taxGetter.getTaxRate("illinois");
        return 12.5;
    }

}
