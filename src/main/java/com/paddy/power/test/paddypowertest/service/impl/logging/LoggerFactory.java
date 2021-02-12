package com.paddy.power.test.paddypowertest.service.impl.logging;

import com.paddy.power.test.paddypowertest.common.constants.LoggerConstants;
import com.paddy.power.test.paddypowertest.service.LoggerService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoggerFactory {

    private final ConsoleLoggerService consoleLoggerService;

    private final FileLoggerService fileLoggerService;

    private static final Map<String, LoggerService> factoryHandler = new HashMap<>();



    public LoggerFactory(ConsoleLoggerService consoleLoggerService, FileLoggerService fileLoggerService) {
        this.consoleLoggerService = consoleLoggerService;
        this.fileLoggerService = fileLoggerService;
    }

    @PostConstruct
    private Map<String, LoggerService> getObject() {
        factoryHandler.put(LoggerConstants.CONSOLE, consoleLoggerService);
        factoryHandler.put(LoggerConstants.FILE, fileLoggerService);
        return factoryHandler;
    }

    public static LoggerService createInstance(String logType) {
        return Optional.ofNullable(factoryHandler.get(logType)).orElseThrow(()->
                new IllegalArgumentException(" Invalid Log Type"));
    }
}
