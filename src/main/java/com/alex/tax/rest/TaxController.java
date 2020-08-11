package com.alex.tax.rest;

import com.alex.tax.exceptions.InvalidTaxRateException;
import com.alex.tax.model.OutputTaxModel;
//import com.alex.tax.service.TaxFactoryConfigurer;
import com.alex.tax.service.TaxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
@RequestMapping("/tax")
@CrossOrigin // allows requests from all domains
public class TaxController {

    
    private TaxService taxService;

@Autowired
    public void setTaxService(TaxService taxService){
        this.taxService = taxService;
    }

    @Operation(summary = "Retriev sales tax for a particular state")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
                    description = "Tax rate was returned with the selected state",
                    content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "404",
                    description = "Tax rate could not be found for the selected state",
                    content = @Content)        
    })
    @RequestMapping(method = RequestMethod.GET, value = "/{state}")
    public ResponseEntity<OutputTaxModel> GetStateTaxRate(@PathVariable("state") String state) {
        try {             
            return new ResponseEntity<OutputTaxModel>( taxService.getTaxRate(state), HttpStatus.OK);
        } catch (InvalidTaxRateException e) {
            return new ResponseEntity<OutputTaxModel>(HttpStatus.NOT_FOUND);
        } 
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/{state}")
    // public ResponseEntity<OutputTaxModel> GetStateTaxRate(@PathVariable("state") String state) {
    //     try {
    //             ApplicationContext context = new AnnotationConfigApplicationContext(TaxFactoryConfigurer.class);

    //         return new ResponseEntity<OutputTaxModel>( context.getBean(TaxService.class).getTaxRate(state), HttpStatus.OK);
    //     } catch (InvalidTaxRateException e) {
    //         return new ResponseEntity<OutputTaxModel>(HttpStatus.NOT_FOUND);
    //     } 
    // }
}

