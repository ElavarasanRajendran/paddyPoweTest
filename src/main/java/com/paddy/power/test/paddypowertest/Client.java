package com.paddy.power.test.paddypowertest;

import com.paddy.power.test.paddypowertest.common.Bet;
import com.paddy.power.test.paddypowertest.common.TotalLiability;
import com.paddy.power.test.paddypowertest.service.FileParserService;
import com.paddy.power.test.paddypowertest.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Client implements CommandLineRunner {

    private final FileParserService fileParserService;
    private final ReportService reportService;

    public Client(final FileParserService fileParserService,
                  final ReportService reportService) {
        this.fileParserService = fileParserService;
        this.reportService = reportService;
    }

    @Override
    public void run(String... args) throws Exception {
      List<Bet> betList =
              fileParserService.parseCsvFile("/Users/elavarasanrajendran/Downloads/BettingSheet.csv");
      List<TotalLiability> totalLiabilityList = reportService.generateTotalLiabilityReport(betList);
    }
}
