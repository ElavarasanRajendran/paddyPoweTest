package com.paddy.power.test.paddypowertest.common.dto;

import lombok.Data;

@Data
public class SelectionLiability {
    private String selectionName;
    private String currency;
    private int numberOfBets;
    private double totalStakes;
    private double totalLiabilities;
}