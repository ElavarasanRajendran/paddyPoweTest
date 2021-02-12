package com.paddy.power.test.paddypowertest.service;

import com.paddy.power.test.paddypowertest.common.dto.Bet;
import com.paddy.power.test.paddypowertest.common.dto.SelectionLiability;
import com.paddy.power.test.paddypowertest.common.dto.TotalLiability;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReportService {
    public List<TotalLiability> generateTotalLiabilityReport(List<Bet> betList);

    public List<SelectionLiability> generateSelectionLiabilityReport(List<Bet> betList);
}
