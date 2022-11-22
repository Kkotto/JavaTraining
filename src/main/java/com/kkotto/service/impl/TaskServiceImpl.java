package com.kkotto.service.impl;

import com.kkotto.consts.TrafficDataFileParams;
import com.kkotto.model.TrafficData;
import com.kkotto.service.TaskService;
import com.kkotto.service.utils.FileUtils;
import com.kkotto.service.utils.ListUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

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
        List<String> fileRecords = FileUtils.readFileByLines(trafficDataFile);
        fileRecords = ListUtils.removeHeader(fileRecords);
        List<TrafficData> trafficDataList = createTrafficDataList(fileRecords);
        logger.info(countLimitTypesActivities(trafficDataList));
        File resultCustomersFile = new File(TrafficDataFileParams.RESULT_CUSTOMER_FILE_PATH);
        List<String> customerNames = findCustomersByLimits(trafficDataList, TrafficDataFileParams.LIMIT_TYPE_LIMIT_MOVEMENT);
        FileUtils.writeToFile(resultCustomersFile, customerNames);
    }

    private Map<String, Integer> countLimitTypesActivities(List<TrafficData> trafficDataList) {
        Map<String, Integer> uniqueLimitTypes = new HashMap<>();
        int startValue = 1;
        for (TrafficData trafficData : trafficDataList) {
            String limitTypeName = trafficData.getLimitTypeName();
            if (uniqueLimitTypes.containsKey(limitTypeName)) {
                int limitsAmount = uniqueLimitTypes.get(limitTypeName);
                uniqueLimitTypes.put(limitTypeName, ++limitsAmount);
            } else {
                uniqueLimitTypes.put(limitTypeName, startValue);
            }
        }
        return uniqueLimitTypes;
    }

    private List<String> findCustomersByLimits(List<TrafficData> trafficDataList, String limitTypeName) {
        return trafficDataList.stream()
                .filter(trafficData -> trafficData.getLimitTypeName().equals(limitTypeName))
                .map(TrafficData::getCustomerName)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<TrafficData> createTrafficDataList(List<String> fileRecords) {
        List<TrafficData> trafficData = new ArrayList<>();
        for (String record : fileRecords) {
            List<String> argumentsInRecord = ListUtils.splitArgumentsInRecord(record);
            trafficData.add(buildTrafficData(argumentsInRecord));
        }
        return trafficData;
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
