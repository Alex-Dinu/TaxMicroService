package com.alex.tax.service.taxrates;

import com.alex.tax.repository.TaxGetter;

import org.springframework.beans.factory.annotation.Autowired;

public class TexasTaxRate implements TaxRater{
    
    //private TaxGetter taxGetter;
   
    //public TexasTaxRate(){}

    // @Autowired
    // public TexasTaxRate(TaxGetter taxGetter){
    //     this.taxGetter = taxGetter;
    //     System.out.println(">>>TexasTaxRate: taxGetter=" + taxGetter.getClass().getName());
    // }


    @Override
    public double getTaxRate() {
        //System.out.println(">>>TexasTaxRate.getTaxRate: taxGetter=" + this.taxGetter.getClass().getName());
        //return this.taxGetter.getTaxRate("texas");
        return 7.5;
    }

}
