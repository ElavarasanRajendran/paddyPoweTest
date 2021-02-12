package com.paddy.power.test.paddypowertest.common.dto;

import lombok.Data;
import lombok.ToString;

import static com.paddy.power.test.paddypowertest.common.constants.LoggerConstants.DECIMAL_FORMAT;

@Data
@ToString
public class TotalLiability {
    private String currency;
    private int numberOfBets;
    private double totalStakes;
    private double totalLiabilities;

    @Override
    public String toString() {
        return  new StringBuilder(this.currency)
                .append("\t\t\t").append(this.numberOfBets)
                .append("\t\t\t\t\t").append(DECIMAL_FORMAT.format(this.totalStakes))
                .append("\t\t\t\t\t").append(DECIMAL_FORMAT.format(this.totalLiabilities)).toString();
    }
}
