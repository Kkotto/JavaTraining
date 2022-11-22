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
        List<TrafficData> trafficDataList = TrafficDataUtils.generateTrafficDataList();
        logger.info(TrafficDataUtils.countLimitTypesActivities(trafficDataList));
        writeUniqueCustomersToFile(trafficDataList);
        writeTopCustomersToFile(trafficDataList);
    }

    private void writeUniqueCustomersToFile(List<TrafficData> trafficDataList) {
        File resultCustomersFile = new File(TrafficDataFileParams.RESULT_CUSTOMER_FILE_PATH);
        List<String> customerNames = TrafficDataUtils.findCustomersByLimitType(trafficDataList, TrafficDataFileParams.LIMIT_TYPE_LIMIT_MOVEMENT);
        FileUtils.writeToFile(resultCustomersFile, customerNames);
    }

    private void writeTopCustomersToFile(List<TrafficData> trafficDataList) {
        File resultTopCustomersFile = new File(TrafficDataFileParams.RESULT_TOP_CUSTOMERS_FILE_PATH);
        List<String> customerNames = TrafficDataUtils.findTopCustomersByTermClarifications(trafficDataList, TrafficDataFileParams.TOP_CUSTOMERS_VALUE);
        FileUtils.writeToFile(resultTopCustomersFile, customerNames);
    }
}
