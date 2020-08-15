package com.alex.tax.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class OutputTaxModel {

    @Schema(
        description = "The state passed in.",
        example = "Texas",
        type = "String"
    )
    private String state;

    @Schema(
        description = "The tax rate.",
        example = "10.3",
        type = "double"
    )
    private double taxRate;

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
