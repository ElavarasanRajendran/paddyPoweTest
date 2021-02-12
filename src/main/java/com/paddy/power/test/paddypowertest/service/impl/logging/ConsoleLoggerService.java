package com.paddy.power.test.paddypowertest.service.impl.logging;

import com.paddy.power.test.paddypowertest.common.dto.SelectionLiability;
import com.paddy.power.test.paddypowertest.common.dto.TotalLiability;
import com.paddy.power.test.paddypowertest.service.LoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.paddy.power.test.paddypowertest.common.constants.LoggerConstants.SELECTION_LIABILITY_LOG_HEADER;
import static com.paddy.power.test.paddypowertest.common.constants.LoggerConstants.TOTAL_LIABILITY_LOG_HEADER;

@Service
public class ConsoleLoggerService implements LoggerService {

    private final Logger logger = LoggerFactory.getLogger(ConsoleLoggerService.class);

    @Override
    public void logReports(List<SelectionLiability> selectionLiabilityList,
                           List<TotalLiability> totalLiabilityList) {
        logger.info("The Selection Liability report is:");
        logger.info(SELECTION_LIABILITY_LOG_HEADER);
        selectionLiabilityList.forEach( selectionLiability -> {
            logger.info(selectionLiability.toString());
        });
        logger.info("\n\n");
        logger.info("The Total Liability report is:");
        logger.info(TOTAL_LIABILITY_LOG_HEADER);
        totalLiabilityList.forEach( totalLiability -> {
            logger.info(totalLiability.toString());
        });
        logger.info("\n\n");
    }
}
