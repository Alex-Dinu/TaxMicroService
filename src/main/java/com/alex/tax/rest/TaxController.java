package com.alex.tax.rest;

import com.alex.tax.exceptions.InvalidTaxRateException;
import com.alex.tax.model.OutputTaxModel;
//import com.alex.tax.service.TaxFactoryConfigurer;
import com.alex.tax.service.TaxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

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
    public ResponseEntity<OutputTaxModel> getStateTaxRate(@PathVariable("state") String state) {
        try {
            OutputTaxModel outputTaxModel = taxService.getTaxRate(state);

            // final String uriString =
            // ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
            Link findOneLink = linkTo(methodOn(TaxController.class).getStateTaxRate(state)).withSelfRel();
            Link findAllLink = linkTo(methodOn(TaxController.class).getAllTaxRates()).withRel("all taxes");
            // outputTaxModel.add(new Link(uriString, "self"));
            outputTaxModel.add(findOneLink);
            outputTaxModel.add(findAllLink);

            return new ResponseEntity<OutputTaxModel>(outputTaxModel, HttpStatus.OK);
        } catch (InvalidTaxRateException e) {
            return new ResponseEntity<OutputTaxModel>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Retriev all tax rates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All tax rates", content = @Content(schema = @Schema(implementation = OutputTaxModel.class))) })

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OutputTaxModel>> getAllTaxRates() {
        List<OutputTaxModel> allTaxes = taxService.getAllTaxRates();

        for (OutputTaxModel outputTaxData : allTaxes) {
            Link findOneLink = linkTo(methodOn(TaxController.class).getStateTaxRate(outputTaxData.getState()))
                    .withRel(outputTaxData.getState() + " tax rate");
            outputTaxData.add(findOneLink);
        }
        // Link findOneLink =
        // linkTo(methodOn(TaxController.class).getStateTaxRate("Texas")).withRel("Texas
        // tax rate");
        // Link findAllLink =
        // linkTo(methodOn(TaxController.class).getAllTaxRates()).withSelfRel();

        // allTaxes.add(findAllLink);

        return new ResponseEntity<List<OutputTaxModel>>(taxService.getAllTaxRates(), HttpStatus.OK);
    }
}
