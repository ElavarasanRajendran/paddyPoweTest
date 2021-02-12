package com.paddy.power.test.paddypowertest.service.impl.logging;

import com.paddy.power.test.paddypowertest.common.dto.SelectionLiability;
import com.paddy.power.test.paddypowertest.common.dto.TotalLiability;
import com.paddy.power.test.paddypowertest.service.LoggerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileLoggerService implements LoggerService{
    @Override
    public void logSelectionLiabilityReport(List<SelectionLiability> selectionLiabilityList) {

    }

    @Override
    public void logTotalLiabilityReport(List<TotalLiability> totalLiabilityList) {

    }
}
