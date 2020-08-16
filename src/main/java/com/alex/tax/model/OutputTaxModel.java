package com.alex.tax.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

public class OutputTaxModel extends RepresentationModel<OutputTaxModel> {

    @Schema(description = "The state passed in.", example = "Texas", type = "String")
    private String state;

    @Schema(description = "The tax rate.", example = "10.3", type = "double")
    private double taxRate;

    public OutputTaxModel(String state, double taxRate) {
        this.state = state;
        this.taxRate = taxRate;
    }

    public OutputTaxModel() {

    }

    // private String content;

    // @JsonCreator
    // public OutputTaxModel(@JsonProperty("content") String content) {
    // this.content = content;
    // }

    // public String getContent() {
    // return content;
    // }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

}
