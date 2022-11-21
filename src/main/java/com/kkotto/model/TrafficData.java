package com.kkotto.model;

public class TrafficData {
    private String customerName;
    private String limitTypeName;
    private String workTypeName;
    private String limitRemovalDate;
    private String termClarification;

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s",
                customerName, limitTypeName, workTypeName, limitRemovalDate, termClarification);
    }

    public static class Builder {
        private final TrafficData dataBuilder;

        public Builder() {
            dataBuilder = new TrafficData();
        }

        public Builder addCustomerName(String customerName) {
            dataBuilder.customerName = customerName;
            return this;
        }

        public Builder addLimitTypeName(String limitTypeName) {
            dataBuilder.limitTypeName = limitTypeName;
            return this;
        }

        public Builder addWorkTypeName(String workTypeName) {
            dataBuilder.workTypeName = workTypeName;
            return this;
        }

        public Builder addLimitRemovalDay(String limitRemovalDay) {
            dataBuilder.limitRemovalDate = limitRemovalDay;
            return this;
        }

        public Builder addTermClarification(String termClarification) {
            dataBuilder.termClarification = termClarification;
            return this;
        }

        public TrafficData build() {
            return dataBuilder;
        }
    }
}
