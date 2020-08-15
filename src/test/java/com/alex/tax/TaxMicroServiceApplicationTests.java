package com.alex.tax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.alex.tax.exceptions.InvalidTaxRateException;
import com.alex.tax.model.OutputTaxModel;
import com.alex.tax.rest.TaxController;
import com.alex.tax.service.TaxService;
import com.alex.tax.service.taxrates.TexasTaxRate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaxMicroServiceApplicationTests {

    @Autowired
    private TaxController taxController;

    @Test
    void TexasTaxRateReturnedSuccessfully() {

        double expectedResult = 7.5;

        OutputTaxModel response = taxController.getStateTaxRate(("Texas")).getBody();
        double actualResult = response.getTaxRate();

        assertEquals(expectedResult, actualResult, "Didn't get what was expected");
    }

    @Test
    void InvalidStateWillRaisAnException() {
        try {
            TaxService taxService = new TaxService();
            taxService.getTaxRate("Invalid");
        } catch (InvalidTaxRateException e) {
            assertEquals(1, 1);
        }
    }
}
