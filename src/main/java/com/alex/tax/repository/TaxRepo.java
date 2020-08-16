package com.alex.tax.repository;

import java.util.ArrayList;
import java.util.List;

import com.alex.tax.model.OutputTaxModel;

public class TaxRepo implements TaxGetter {

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

    @Override
    public List<OutputTaxModel> getAllTaxRates() {
        OutputTaxModel outputTaxModel;
        List<OutputTaxModel> allTaxes = new ArrayList<>();

        outputTaxModel = new OutputTaxModel("Texas", 7.5d);
        allTaxes.add(outputTaxModel);
        outputTaxModel = new OutputTaxModel("Illinois", 12.5d);
        allTaxes.add(outputTaxModel);
        outputTaxModel = new OutputTaxModel("Florida", 6.5d);
        allTaxes.add(outputTaxModel);

        return allTaxes;
    }
}