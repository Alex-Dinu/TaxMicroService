package com.alex.tax.service;

import com.alex.tax.exceptions.InvalidTaxRateException;
import com.alex.tax.model.OutputTaxModel;
import com.alex.tax.service.factory.TaxFactoryOrchestrator;
import com.alex.tax.service.taxrates.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService implements TaxServicer{

    private TaxFactoryOrchestrator taxFactory;

    public TaxService(){}

    @Autowired
    public TaxService(TaxFactoryOrchestrator taxFactory){
        this.taxFactory = taxFactory;
    }

    // 
    // public void setTaxFactoryOrchestrator(TaxFactoryOrchestrator taxFactory){
    //     this.taxFactory = taxFactory;
    // }
    @Override
    public OutputTaxModel getTaxRate(String state) throws InvalidTaxRateException {
        var response = new OutputTaxModel();
        response.setState(state);
        response.setTaxRate(getTaxRater(state).getTaxRate());
        return response;
    } 

    private TaxRater getTaxRater (String state) throws InvalidTaxRateException {
        try{
        return this.taxFactory.getTaxRater(state);
        }
        catch(Exception e) {
            throw new InvalidTaxRateException("Could not retrieve tax rate for " + state + ".");
        }
    }
}

