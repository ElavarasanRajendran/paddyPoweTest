package com.paddy.power.test.paddypowertest;

import com.paddy.power.test.paddypowertest.common.Bet;
import com.paddy.power.test.paddypowertest.service.FileParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Client implements CommandLineRunner {

    private final FileParserService fileParserService;

    public Client(FileParserService fileParserService) {
        this.fileParserService = fileParserService;
    }

    @Override
    public void run(String... args) throws Exception {
      List<Bet> betList =  fileParserService.parseCsvFile("/Users/elavarasanrajendran/Downloads/BettingSheet.csv");
    }
}
