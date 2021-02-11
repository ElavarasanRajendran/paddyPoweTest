package com.paddy.power.test.paddypowertest.service;

import com.paddy.power.test.paddypowertest.common.Bet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileParserService {
    public List<Bet> parseCsvFile(String location);
}
