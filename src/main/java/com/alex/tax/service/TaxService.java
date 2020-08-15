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
    private TaxRater taxRater;
    

    public TaxService(){}

    @Autowired
    public void setTaxFactory(TaxFactoryOrchestrator taxFactory) {
        this.taxFactory = taxFactory;
    }

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
        //System.out.println(">>> TaxService.getTaxRate: getting tax getter");
        setTaxRater(getTaxRater(state));
        //System.out.println(">>> TaxService.getTaxRate: got tax getter = "+ tax.getClass().getCanonicalName());
        response.setTaxRate(getTaxRater().getTaxRate());
        //System.out.println(">>> TaxService.getTaxRate: called tax getter");
        return response;
    } 

    private TaxRater getTaxRater (String state) throws InvalidTaxRateException {
        try{
            //System.out.println(">>>TaxService.getTaxRater: = " + this.taxFactory.getTaxRater(state).getClass().getName());
            return this.taxFactory.getTaxRater(state);
        }
        catch(Exception e) {
            throw new InvalidTaxRateException("Could not retrieve tax rate for " + state + ".");
        }
    }

    public TaxRater getTaxRater() {
        return taxRater;
    }

    public void setTaxRater(TaxRater taxRater) {
        this.taxRater = taxRater;
    }



}

