package com.alex.tax.service.factory;

import java.lang.reflect.InvocationTargetException;

import com.alex.tax.service.taxrates.*;

public class TaxFactory implements TaxFactoryOrchestrator {

    public TaxRater getTaxRater(String state) throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        return (TaxRater) Class.forName(getClassName(state)).getDeclaredConstructor().newInstance();
    }

    private String getClassName(String state)
    {
        return "com.alex.tax.service.taxrates." + state + "TaxRate";
    }

}
