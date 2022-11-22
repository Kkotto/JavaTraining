package com.kkotto.service.utils;

import com.kkotto.consts.TrafficDataFileParams;
import com.kkotto.model.TrafficData;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TrafficDataUtils {
    public static List<TrafficData> generateTrafficDataList() {
        File trafficDataFile = new File(TrafficDataFileParams.TRAFFIC_DATA_FILE_PATH);
        List<String> fileRecords = FileUtils.readFileByLines(trafficDataFile);
        fileRecords = ListUtils.removeHeader(fileRecords);
        return fillTrafficDataList(fileRecords);
    }

    public static List<TrafficData> fillTrafficDataList(List<String> fileRecords) {
        List<TrafficData> trafficData = new ArrayList<>();
        for (String record : fileRecords) {
            List<String> argumentsInRecord = ListUtils.splitArgumentsInRecord(record);
            trafficData.add(buildTrafficData(argumentsInRecord));
        }
        return trafficData;
    }

    public static List<String> findCustomersByWorkType(List<TrafficData> trafficDataList, String workTypeName) {
        return trafficDataList.stream()
                .filter(trafficData -> trafficData.getWorkTypeName().equals(workTypeName))
                .map(TrafficData::getCustomerName)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> findTopCustomersByTermClarifications(List<TrafficData> trafficDataList, int topValue) {
        Map<String, Integer> customersClarificationsAmount = countCustomersTermClarifications(trafficDataList);
        List<String> customerNames = sortCustomersByTermValue(customersClarificationsAmount);
        return customerNames.subList(0, topValue);
    }

    public static List<String> sortCustomersByTermValue(Map<String, Integer> customersClarificationsAmount) {
        List<Map.Entry<String, Integer>> customersEntry = customersClarificationsAmount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();
        List<String> keySet = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : customersEntry) {
            keySet.add(entry.getKey());
        }
        return keySet;
    }

    public static Map<String, Integer> countCustomersTermClarifications(List<TrafficData> trafficDataList) {
        Map<String, Integer> customersClarificationAmount = new HashMap<>();
        int startValue = 1;
        for (TrafficData trafficData : trafficDataList) {
            String customerName = trafficData.getCustomerName();
            if (!trafficData.getTermClarification().equals(TrafficDataFileParams.NO_INFO_RECORD_VALUE)) {
                if (customersClarificationAmount.containsKey(customerName)) {
                    int limitsAmount = customersClarificationAmount.get(customerName);
                    customersClarificationAmount.put(customerName, ++limitsAmount);
                } else {
                    customersClarificationAmount.put(customerName, startValue);
                }
            }
        }
        return customersClarificationAmount;
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

    public static List<TrafficData> findRecordsInDateBounds(List<TrafficData> trafficDataList, LocalDate startDate, LocalDate endDate) {
        List<TrafficData> filteredRecords = new ArrayList<>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(TrafficDataFileParams.DATE_FORMAT);
        for (TrafficData trafficData : trafficDataList) {
            String trafficDataDate = trafficData.getLimitRemovalDate();
            if (!trafficDataDate.equals(TrafficDataFileParams.NO_INFO_RECORD_VALUE)) {
                LocalDate recordDate = LocalDate.parse(trafficDataDate, dateFormat);
                if (recordDate.isAfter(startDate) && recordDate.isBefore(endDate)) {
                    filteredRecords.add(trafficData);
                }
            }
        }
        return filteredRecords;
    }

    public static TrafficData buildTrafficData(List<String> recordArguments) {
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

    public static void parseDate(List<TrafficData> trafficDataList) {
        int yearLength = 4, monthLength = 2;
        String dateSeparator = "/";
        for (TrafficData trafficData : trafficDataList) {
            String date = trafficData.getLimitRemovalDate();
            if (!date.equals(TrafficDataFileParams.NO_INFO_RECORD_VALUE) && !date.matches(TrafficDataFileParams.DATE_FORMAT)) {
                StringBuilder dateBuilder = new StringBuilder();
                dateBuilder.append(date, 0, yearLength)
                        .append(dateSeparator)
                        .append(date, yearLength, yearLength + monthLength)
                        .append(dateSeparator)
                        .append(date.substring(yearLength + monthLength));
                trafficData.setLimitRemovalDate(dateBuilder.toString());
            }
        }
    }
}
