package com.alex.tax;

import com.alex.tax.model.OutputTaxModel;
import com.alex.tax.service.TaxService;
import com.alex.tax.service.factory.TaxFactoryOrchestrator;
import com.alex.tax.service.taxrates.TaxRater;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UnitTests {
    
    private TaxService taxService;

    @Mock
    private TaxFactoryOrchestrator taxFactoryOrchestrator;

    @Mock
    private TaxRater taxRater;
    
    @Mock
    OutputTaxModel outputTaxModel;

    @BeforeAll
    public void SetupMock(){
        MockitoAnnotations.initMocks(this);
        taxService = new TaxService();
        taxService.setTaxRater(taxRater);
    }

    // @Test
    // public void shouldReturnTaxRate() {
    //     // Arrange.
    //     when(taxRater.getTaxRate().)
    // }

    
}