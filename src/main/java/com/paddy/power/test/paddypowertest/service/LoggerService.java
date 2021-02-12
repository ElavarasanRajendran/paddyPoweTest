package com.paddy.power.test.paddypowertest.service;

import com.paddy.power.test.paddypowertest.common.dto.SelectionLiability;
import com.paddy.power.test.paddypowertest.common.dto.TotalLiability;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface LoggerService {
    void logReports(List<SelectionLiability> selectionLiabilityList,
                    List<TotalLiability> totalLiabilityList) throws IOException;
}
