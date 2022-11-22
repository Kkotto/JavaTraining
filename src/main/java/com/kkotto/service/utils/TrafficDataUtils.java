package com.kkotto.service.utils;

import com.kkotto.consts.TrafficDataFileParams;
import com.kkotto.model.TrafficData;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrafficDataUtils {
    public static List<TrafficData> generateTrafficDataList() {
        File trafficDataFile = new File(TrafficDataFileParams.TRAFFIC_DATA_FILE_PATH);
        List<String> fileRecords = FileUtils.readFileByLines(trafficDataFile);
        fileRecords = ListUtils.removeHeader(fileRecords);
        return fillTrafficDataList(fileRecords);
    }

    private static List<TrafficData> fillTrafficDataList(List<String> fileRecords) {
        List<TrafficData> trafficData = new ArrayList<>();
        for (String record : fileRecords) {
            List<String> argumentsInRecord = ListUtils.splitArgumentsInRecord(record);
            trafficData.add(buildTrafficData(argumentsInRecord));
        }
        return trafficData;
    }

    public static List<String> findCustomersByLimits(List<TrafficData> trafficDataList, String limitTypeName) {
        return trafficDataList.stream()
                .filter(trafficData -> trafficData.getLimitTypeName().equals(limitTypeName))
                .map(TrafficData::getCustomerName)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> countLimitTypesActivities(List<TrafficData> trafficDataList) {
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

    private static TrafficData buildTrafficData(List<String> recordArguments) {
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
