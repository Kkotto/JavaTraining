package com.kkotto.service.impl;

import com.kkotto.consts.TrafficDataFileParams;
import com.kkotto.model.TrafficData;
import com.kkotto.service.TaskService;
import com.kkotto.service.utils.FileUtils;
import com.kkotto.service.utils.TrafficDataUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;

public class TaskServiceImpl implements TaskService {
    private static TaskServiceImpl instance;
    private final FileUtils fileUtil;
    private final TrafficDataUtils trafficDataUtil;
    static final Logger logger = LogManager.getLogger(TaskServiceImpl.class);

    private TaskServiceImpl() {
        fileUtil = FileUtils.getInstance();
        trafficDataUtil = TrafficDataUtils.getInstance();
    }

    public static TaskServiceImpl getInstance() {
        if (instance == null) {
            instance = new TaskServiceImpl();
        }
        return instance;
    }

    @Override
    public void runTask() {
        List<TrafficData> trafficDataList = trafficDataUtil.generateTrafficDataList();
        logger.info(trafficDataUtil.countLimitTypesActivities(trafficDataList));
        writeUniqueCustomersToFile(trafficDataList);
        writeTopCustomersToFile(trafficDataList);
        writeRecordsInPeriod(trafficDataList);
    }

    private void writeUniqueCustomersToFile(List<TrafficData> trafficDataList) {
        File resultCustomersFile = new File(TrafficDataFileParams.RESULT_CUSTOMER_FILE_PATH);
        List<String> customerNames = trafficDataUtil.findCustomersByWorkType(trafficDataList, TrafficDataFileParams.WORK_TYPE_LIMIT_MOVEMENT);
        fileUtil.writeToFile(resultCustomersFile, customerNames);
    }

    private void writeTopCustomersToFile(List<TrafficData> trafficDataList) {
        File resultTopCustomersFile = new File(TrafficDataFileParams.RESULT_TOP_CUSTOMERS_FILE_PATH);
        List<String> customerNames = trafficDataUtil.findTopCustomersByTermClarifications(trafficDataList, TrafficDataFileParams.TOP_CUSTOMERS_VALUE);
        fileUtil.writeToFile(resultTopCustomersFile, customerNames);
    }

    private void writeRecordsInPeriod(List<TrafficData> trafficDataList) {
        File historyFile = new File(TrafficDataFileParams.RESULT_HISTORY_FILE_PATH);
        trafficDataUtil.parseDate(trafficDataList);
        List<TrafficData> trafficData = trafficDataUtil.findRecordsInDateBounds(trafficDataList, TrafficDataFileParams.START_WORK_DATE, TrafficDataFileParams.END_WORK_DATE);
        List<String> customerNames = trafficData.stream()
                .map(TrafficData::getCustomerName)
                .toList();
        fileUtil.writeToFile(historyFile, customerNames);
    }
}
