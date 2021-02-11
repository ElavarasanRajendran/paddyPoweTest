package com.paddy.power.test.paddypowertest.service.impl;

import com.paddy.power.test.paddypowertest.common.Bet;
import com.paddy.power.test.paddypowertest.service.FileParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FileParserServiceImpl implements FileParserService {

    private static final Logger logger = LoggerFactory.getLogger(FileParserServiceImpl.class);
    private static final String COMMA = ",";

    @Override
    public List<Bet> parseCsvFile(String location) {
        List<Bet> inputList = new ArrayList<>();
        try{

            File inputF = new File(location);
            InputStream inputFS = new FileInputStream(inputF);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputFS))) {

                inputList = br.lines().skip(1).map((Function<String, Bet>)
                        this::mapToBet).collect(Collectors.toList());
                br.close();
            }
        } catch (FileNotFoundException e) {
            logger.info("File cannot be found at the location", e.getMessage());
        } catch (IOException e) {
            logger.info("File cannot be read", e.getMessage());
        }

        return inputList ;
    }

    private Bet mapToBet(String line) {
        String[] p = line.split(COMMA);
        int size = p.length;
        Bet bet = new Bet();

        bet.setBedId(p[0]);
        if (p[1] != null && p[1].trim().length() > 0) {
            bet.setTimestamp(p[1]);
        }

        if (p[2] != null && p[2].trim().length() > 0) {
            bet.setSelectionId(Integer.valueOf(p[2]));
        }

        if (p[3] != null && p[3].trim().length() > 0) {
            bet.setSelectionName(p[3]);
        }

        if (p[4] != null && p[4].trim().length() > 0) {
            bet.setStake(Float.valueOf(p[4]));
        }

        if (p[5] != null && p[5].trim().length() > 0) {
            bet.setPrice(Float.valueOf(p[5]));
        }

        if (p[6] != null && p[6].trim().length() > 0) {
            bet.setCurrency(p[6]);
        }
        return bet;
    }
}
