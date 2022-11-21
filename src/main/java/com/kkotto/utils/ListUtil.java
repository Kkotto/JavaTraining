package com.kkotto.utils;

import com.kkotto.consts.TrafficDataFileParams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {

    public static List<String> splitArgumentsInRecord(String record) {
        List<String> recordArguments;
        if (record.contains(TrafficDataFileParams.RECORD_COMPLEX_FIELD_REGEX)) {
            recordArguments = splitComplexRecord(record);
        } else {
            recordArguments = Arrays.asList(record.split(TrafficDataFileParams.RECORDS_SPLIT_REGEX));
        }
        return recordArguments;
    }

    public static List<String> splitComplexRecord(String complexRecord) {
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
}
