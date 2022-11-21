package com.kkotto.model;

public class TrafficData {
    private int recordCode;
    private String orderNumber;
    private String customerName; //<--
    private int customerID;
    private String contractorName;
    private int contractorID;
    private String regionName;
    private String address;
    private String limitTypeName; //<--
    private String workTypeName; //<--
    private String limitStartDate; //<--
    private String limitEndDate; //<--
    private String limitRemovalDay; //<--
    private String termClarification; //<--
    private String documentSourceLink;
    private String monitoringSourceLink;
    private String basisSourceLink;
    private String pspSourceLink;
    private String mskSourceLink;
    private String caseAdminSourceLink;

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s",
                recordCode, orderNumber, customerName, customerID, contractorName, contractorID, regionName, address,
                limitTypeName, workTypeName, limitStartDate, limitEndDate, limitRemovalDay, termClarification, documentSourceLink,
                monitoringSourceLink, basisSourceLink, pspSourceLink, mskSourceLink, caseAdminSourceLink);
    }

    public static class Builder {
        private final TrafficData dataBuilder;

        public Builder() {
            dataBuilder = new TrafficData();
        }

        public Builder addRecordCode(int recordCode) {
            dataBuilder.recordCode = recordCode;
            return this;
        }

        public Builder addOrderNumber(String orderNumber) {
            dataBuilder.orderNumber = orderNumber;
            return this;
        }

        public Builder addCustomerName(String customerName) {
            dataBuilder.customerName = customerName;
            return this;
        }

        public Builder addCustomerId(int customerID) {
            dataBuilder.customerID = customerID;
            return this;
        }

        public Builder addContractorName(String contractorName) {
            dataBuilder.contractorName = contractorName;
            return this;
        }

        public Builder addContractorID(int contractorID) {
            dataBuilder.contractorID = contractorID;
            return this;
        }

        public Builder addRegionName(String regionName) {
            dataBuilder.regionName = regionName;
            return this;
        }

        public Builder addAddress(String address) {
            dataBuilder.address = address;
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

        public Builder addLimitStartDate(String limitStartDate) {
            dataBuilder.limitStartDate = limitStartDate;
            return this;
        }

        public Builder addLimitEndDate(String limitEndDate) {
            dataBuilder.limitEndDate = limitEndDate;
            return this;
        }

        public Builder addLimitRemovalDay(String limitRemovalDay) {
            dataBuilder.limitRemovalDay = limitRemovalDay;
            return this;
        }

        public Builder addTermClarification(String termClarification) {
            dataBuilder.termClarification = termClarification;
            return this;
        }

        public Builder addDocumentSourceLink(String documentSourceLink) {
            dataBuilder.documentSourceLink = documentSourceLink;
            return this;
        }

        public Builder addMonitoringSourceLink(String monitoringSourceLink) {
            dataBuilder.monitoringSourceLink = monitoringSourceLink;
            return this;
        }

        public Builder addBasisSourceLink(String basisSourceLink) {
            dataBuilder.basisSourceLink = basisSourceLink;
            return this;
        }

        public Builder addPspSourceLink(String pspSourceLink) {
            dataBuilder.pspSourceLink = pspSourceLink;
            return this;
        }

        public Builder addMskSourceLink(String mskSourceLink) {
            dataBuilder.mskSourceLink = mskSourceLink;
            return this;
        }

        public Builder addCaseAdminSourceLink(String caseAdminSourceLink) {
            dataBuilder.caseAdminSourceLink = caseAdminSourceLink;
            return this;
        }

        public TrafficData build() {
            return dataBuilder;
        }
    }
}
