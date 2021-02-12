package com.paddy.power.test.paddypowertest.service.impl.logging;

import com.paddy.power.test.paddypowertest.common.dto.SelectionLiability;
import com.paddy.power.test.paddypowertest.common.dto.TotalLiability;
import com.paddy.power.test.paddypowertest.service.LoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleLoggerService implements LoggerService {

    private final Logger logger = LoggerFactory.getLogger(ConsoleLoggerService.class);

    @Override
    public void logSelectionLiabilityReport(List<SelectionLiability> selectionLiabilityList) {
        logger.info("The Selection Liability report is:");
        logger.info("Selection Name \t\t Currency \t\t No of Bets \t\t Total Stakes \t\t Total Liabilities");
        selectionLiabilityList.forEach( selectionLiability -> {
            logger.info(selectionLiability.toString());
        });
        logger.info("\n\n");
    }

    @Override
    public void logTotalLiabilityReport(List<TotalLiability> totalLiabilityList) {
        logger.info("The Total Liability report is:");
        logger.info("Currency \t No of Bets \t Total Stakes \t Total Liabilities");
        totalLiabilityList.forEach( totalLiability -> {
            logger.info(totalLiability.toString());
        });
        logger.info("\n\n");
    }
}
