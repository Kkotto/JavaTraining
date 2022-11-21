package com.kkotto.service.impl;

import com.kkotto.consts.TrafficDataFileParams;
import com.kkotto.model.TrafficData;
import com.kkotto.service.TaskService;
import com.kkotto.utils.FileUtil;
import com.kkotto.utils.ListUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
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
        List<TrafficData> trafficDataList = createTrafficDataList(fileRecords);
        for (TrafficData dataRecord : trafficDataList) {
            logger.info(dataRecord);
        }
    }

    private List<TrafficData> createTrafficDataList(List<String> fileRecords) {
        List<TrafficData> trafficData = new ArrayList<>();
        for (String record : fileRecords) {
            List<String> argumentsInRecord = ListUtil.splitArgumentsInRecord(record);
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
