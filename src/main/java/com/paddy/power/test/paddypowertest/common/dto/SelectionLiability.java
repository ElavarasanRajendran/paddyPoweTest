package com.paddy.power.test.paddypowertest.common.dto;

import lombok.Data;

import java.text.DecimalFormat;

import static com.paddy.power.test.paddypowertest.common.constants.LoggerConstants.DECIMAL_FORMAT;

@Data
public class SelectionLiability {
    private String selectionName;
    private String currency;
    private int numberOfBets;
    private double totalStakes;
    private double totalLiabilities;

    @Override
    public String toString() {
        return new StringBuilder(this.selectionName)
                .append("\t").append("\t").append(this.currency)
                .append("\t\t\t")
                .append("\t").append("\t").append(this.numberOfBets)
                .append("\t\t\t")
                .append("\t").append("\t").append(DECIMAL_FORMAT.format(this.totalStakes))
                .append("\t\t\t")
                .append("\t").append("\t").append(DECIMAL_FORMAT.format(this.totalLiabilities))
                .toString();
    }

}