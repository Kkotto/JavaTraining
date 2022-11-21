package com.kkotto.service.impl;

import com.kkotto.model.TrafficData;
import com.kkotto.service.TaskService;
import com.kkotto.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private static TaskServiceImpl instance;
    private final String DATA_FILE_PATH = "archive\\data.csv";
    private final String RECORDS_SPLIT_REGEX = ",";

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
        File dataTrafficFile = new File(DATA_FILE_PATH);
        List<String> dataRecordsList = FileUtil.readFileByLines(dataTrafficFile);
        List<TrafficData> trafficRecordsList = readTrafficRecords(dataRecordsList);
        trafficRecordsList.forEach(System.out::println);
    }

    private List<TrafficData> readTrafficRecords(List<String> dataRecordsList) {
        List<TrafficData> trafficDataList = new ArrayList<>();
        for (String record : dataRecordsList) {
            List<String> recordArguments = Arrays.asList(record.split(RECORDS_SPLIT_REGEX));
            try {
                TrafficData tempDataObject = createTrafficDataObject(recordArguments);
                if (tempDataObject == null) {
                    throw new IllegalStateException();
                }
                trafficDataList.add(tempDataObject);
                System.out.println("Added.");
            } catch (IllegalStateException exception) {
                System.out.println("Invalid.");
            }
        }
        return trafficDataList;
    }

    private TrafficData createTrafficDataObject(List<String> recordArguments) {
        int counter = 0;
        //try {
        Integer recordCode = Integer.parseInt(recordArguments.get(counter++));
        String orderNumber = recordArguments.get(counter++);
        String customerName = recordArguments.get(counter++);
        int customerID = Integer.parseInt(recordArguments.get(counter++));
        String contractorName = recordArguments.get(counter++);
        int contractorID = Integer.parseInt(recordArguments.get(counter++));
        String regionName = recordArguments.get(counter++);
        String address = recordArguments.get(counter++);
        String limitTypeName = recordArguments.get(counter++);
        String workTypeName = recordArguments.get(counter++);
        String limitStartDate = recordArguments.get(counter++);
        String limitEndDate = recordArguments.get(counter++);
        String limitRemovalDay = recordArguments.get(counter++);
        String termClarification = recordArguments.get(counter++);
        String documentSourceLink = recordArguments.get(counter++);
        String monitoringSourceLink = recordArguments.get(counter++);
        String basisSourceLink = recordArguments.get(counter++);
        String pspSourceLink = recordArguments.get(counter++);
        String mskSourceLink = recordArguments.get(counter++);
        String caseAdminSourceLink = recordArguments.get(counter);
        return new TrafficData.Builder()
                .addRecordCode(recordCode)
                .addOrderNumber(orderNumber)
                .addCustomerName(customerName)
                .addCustomerId(customerID)
                .addContractorName(contractorName)
                .addContractorID(contractorID)
                .addRegionName(regionName)
                .addAddress(address)
                .addLimitTypeName(limitTypeName)
                .addWorkTypeName(workTypeName)
                .addLimitStartDate(limitStartDate)
                .addLimitEndDate(limitEndDate)
                .addLimitRemovalDay(limitRemovalDay)
                .addTermClarification(termClarification)
                .addDocumentSourceLink(documentSourceLink)
                .addMonitoringSourceLink(monitoringSourceLink)
                .addBasisSourceLink(basisSourceLink)
                .addPspSourceLink(pspSourceLink)
                .addMskSourceLink(mskSourceLink)
                .addCaseAdminSourceLink(caseAdminSourceLink)
                .build();
       /*} catch (NumberFormatException e) {
            System.out.println("Not valid record!");
            return null;
        }*/
    }
}
