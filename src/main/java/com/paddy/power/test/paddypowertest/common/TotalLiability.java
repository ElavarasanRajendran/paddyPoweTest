package com.paddy.power.test.paddypowertest.common;

import lombok.Data;

@Data
public class TotalLiability {
    private String currency;
    private int numberOfBets;
    private double totalStakes;
    private double totalLiabilities;
}
