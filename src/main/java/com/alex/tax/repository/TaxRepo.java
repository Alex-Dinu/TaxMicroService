package com.alex.tax.repository;

public class TaxRepo implements TaxGetter{

    @Override
    public double getTaxRate(String state) {
        double stateTaxRate = 0.0;
        String stateToSearchBy = state.toLowerCase();
        switch (stateToSearchBy) {
            case "texas":
                stateTaxRate = 7.5;
                break;     
            case "illinois":
                stateTaxRate = 12.5;
                break;  
            case "florida":
                stateTaxRate = 6.5;
                break;                    
            default:
                break;
        }

        return stateTaxRate;
    }
    
}