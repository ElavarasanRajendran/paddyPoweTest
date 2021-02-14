package com.paddy.power.test.paddypowertest.service;

import com.paddy.power.test.paddypowertest.common.dto.Bet;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public interface FileParserService<T,S> {
    public List<S> readInputData(T file);
}
