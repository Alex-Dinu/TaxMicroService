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
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/tax")
@CrossOrigin // allows requests from all domains
@Tag(name = "State Tax Rates", description = "<b>Showcases the following:</b> \n 1. Microservice \n 2. Factory Pattern \n\t 2.1 Dynamically instanciate classes using reflection \n 3. OpenApi and Swagger \n 4. Custom exceptions \n 5. Interceptors \n\n <b> TODO: </b> \n 1. Add ecxeption object as response")
public class TaxController {

    private TaxService taxService;

    @Autowired
    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    @Operation(summary = "Retriev sales tax for a particular state")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tax rate was returned with the selected state", content = @Content(schema = @Schema(implementation = OutputTaxModel.class))),
            @ApiResponse(responseCode = "404", description = "Tax rate could not be found for the selected state") })
    @RequestMapping(method = RequestMethod.GET, value = "/{state}")
    public ResponseEntity<OutputTaxModel> GetStateTaxRate(@PathVariable("state") String state) {
        try {
            return new ResponseEntity<OutputTaxModel>(taxService.getTaxRate(state), HttpStatus.OK);
        } catch (InvalidTaxRateException e) {
            return new ResponseEntity<OutputTaxModel>(HttpStatus.NOT_FOUND);
        }
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/{state}")
    // public ResponseEntity<OutputTaxModel> GetStateTaxRate(@PathVariable("state")
    // String state) {
    // try {
    // ApplicationContext context = new
    // AnnotationConfigApplicationContext(TaxFactoryConfigurer.class);

    // return new ResponseEntity<OutputTaxModel>(
    // context.getBean(TaxService.class).getTaxRate(state), HttpStatus.OK);
    // } catch (InvalidTaxRateException e) {
    // return new ResponseEntity<OutputTaxModel>(HttpStatus.NOT_FOUND);
    // }
    // }
}
