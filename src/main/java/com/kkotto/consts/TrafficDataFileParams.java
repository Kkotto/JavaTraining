package com.kkotto.consts;

import java.time.LocalDate;

public class TrafficDataFileParams {
    public static final String TRAFFIC_DATA_FILE_PATH = "archive\\data.csv";
    public static final String RESULT_CUSTOMER_FILE_PATH = "result_files\\zakazchik.txt";
    public static final String RESULT_TOP_CUSTOMERS_FILE_PATH = "result_files\\top.txt";
    public static final String RESULT_HISTORY_FILE_PATH = "result_files\\history.txt";
    public static final String WORK_TYPE_LIMIT_MOVEMENT = "огранич.движения";
    public static final String RECORDS_SPLIT_REGEX = ",";
    public static final String RECORD_COMPLEX_FIELD_REGEX = "\"";
    public static final String NO_INFO_RECORD_VALUE = "-";
    public static final LocalDate START_WORK_DATE = LocalDate.of(2020, 12, 1);
    public static final LocalDate END_WORK_DATE = LocalDate.of(2021, 1, 1);
    public static final String DATE_FORMAT = "yyyy/MM/dd";
    public static final int CUSTOMER_NAME_COLUMN_NUMBER = 2;
    public static final int LIMIT_TYPE_NAME_COLUMN_NUMBER = 8;
    public static final int WORK_TYPE_NAME_COLUMN_NUMBER = 9;
    public static final int LIMIT_REMOVAL_DATE_COLUMN_NUMBER = 12;
    public static final int TERM_CLARIFICATION_COLUMN_NUMBER = 13;
    public static final int TOP_CUSTOMERS_VALUE = 10;
}
