package com.paddy.power.test.paddypowertest.common.constants;

import java.text.DecimalFormat;

public class LoggerConstants {

    private LoggerConstants() {
        // Prevent Instantiation;
    }

    public static final String CONSOLE = "CONSOLE";
    public static final String FILE = "FILE";

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("##.00");

    public static final String TOTAL_LIABILITY_LOG_HEADER = "Currency \t No of Bets \t Total Stakes \t Total Liabilities";
    public static final String SELECTION_LIABILITY_LOG_HEADER = "Selection Name \t\t Currency \t\t No of Bets \t\t Total Stakes \t\t Total Liabilities";

}
