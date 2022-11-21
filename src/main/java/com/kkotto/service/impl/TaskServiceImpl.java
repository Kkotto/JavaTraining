package com.kkotto.service.impl;

import com.kkotto.consts.TrafficDataFileParams;
import com.kkotto.model.TrafficData;
import com.kkotto.service.TaskService;
import com.kkotto.util.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private static TaskServiceImpl instance;
    static final Logger logger = LogManager.getLogger(TaskServiceImpl.class);

    private TaskServiceImpl() {
    }

    public static TaskServiceImpl getInstance() {
        if (instance == null) {
            instance = new TaskServiceImpl();
        }
        return instance;
    }

    @Override
    public void runTask() {
        File trafficDataFile = new File(TrafficDataFileParams.TRAFFIC_DATA_FILE_PATH);
        List<String> fileRecords = FileUtil.readFileByLines(trafficDataFile);
        List<TrafficData> trafficData = readTrafficRecords(fileRecords);
        for (TrafficData dataRecord : trafficData) {
            logger.info(dataRecord);
        }
    }

    private List<TrafficData> readTrafficRecords(List<String> fileRecords) {
        List<TrafficData> trafficData = new ArrayList<>();
        for (String record : fileRecords) {
            List<String> recordArguments = readArgumentsInRecord(record);
            trafficData.add(buildTrafficData(recordArguments));
        }
        return trafficData;
    }

    private List<String> readArgumentsInRecord(String record) {
        List<String> recordArguments;
        if (record.contains(TrafficDataFileParams.RECORD_COMPLEX_FIELD_REGEX)) {
            recordArguments = readComplexRow(record);
        } else {
            recordArguments = Arrays.asList(record.split(TrafficDataFileParams.RECORDS_SPLIT_REGEX));
        }
        return recordArguments;
    }

    private List<String> readComplexRow(String complexRecord) {
        String complexRegex = TrafficDataFileParams.RECORD_COMPLEX_FIELD_REGEX;
        String splitRegex = TrafficDataFileParams.RECORDS_SPLIT_REGEX;
        int includeLastElementToBound = 1;
        StringBuilder stringBuilder = new StringBuilder(complexRecord);
        List<String> recordArguments = new ArrayList<>();
        while (stringBuilder.indexOf(splitRegex) > 0) {
            if (stringBuilder.indexOf(complexRegex) == 0) {
                stringBuilder.delete(stringBuilder.indexOf(complexRegex), includeLastElementToBound);
                recordArguments.add(stringBuilder.substring(0, stringBuilder.indexOf(complexRegex)));
                stringBuilder.delete(0, stringBuilder.indexOf(complexRegex) + includeLastElementToBound);
            } else {
                recordArguments.add(stringBuilder.substring(0, stringBuilder.indexOf(splitRegex)));
            }
            stringBuilder.delete(0, stringBuilder.indexOf(splitRegex) + includeLastElementToBound);
        }
        recordArguments.add(stringBuilder.toString());
        return recordArguments;
    }

    private TrafficData buildTrafficData(List<String> recordArguments) {
        String customerName = recordArguments.get(TrafficDataFileParams.CUSTOMER_NAME_COLUMN_NUMBER);
        String limitTypeName = recordArguments.get(TrafficDataFileParams.LIMIT_TYPE_NAME_COLUMN_NUMBER);
        String workTypeName = recordArguments.get(TrafficDataFileParams.WORK_TYPE_NAME_COLUMN_NUMBER);
        String limitRemovalDate = recordArguments.get(TrafficDataFileParams.LIMIT_REMOVAL_DATE_COLUMN_NUMBER);
        String termClarification = recordArguments.get(TrafficDataFileParams.TERM_CLARIFICATION_COLUMN_NUMBER);
        return new TrafficData.Builder()
                .addCustomerName(customerName)
                .addLimitTypeName(limitTypeName)
                .addWorkTypeName(workTypeName)
                .addLimitRemovalDay(limitRemovalDate)
                .addTermClarification(termClarification)
                .build();
    }
}
