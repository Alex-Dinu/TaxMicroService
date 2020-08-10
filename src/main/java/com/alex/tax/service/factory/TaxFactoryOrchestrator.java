package com.alex.tax.service.factory;

import java.lang.reflect.InvocationTargetException;

import com.alex.tax.service.taxrates.TaxRater;

public interface TaxFactoryOrchestrator {
    public TaxRater getTaxRater(String state) throws InstantiationException, IllegalAccessException, IllegalArgumentException,
    InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException;
}

