package com.paddy.power.test.paddypowertest.service;

import com.paddy.power.test.paddypowertest.common.Bet;
import com.paddy.power.test.paddypowertest.common.TotalLiability;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReportService {
    public List<TotalLiability> generateTotalLiabilityReport(List<Bet> betList);
}
