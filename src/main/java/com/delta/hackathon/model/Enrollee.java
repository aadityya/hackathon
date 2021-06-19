package com.delta.hackathon.model;

import java.util.List;

public class Enrollee {
    private String enrolleeId;
    private String enrolleeName;
    private double deductible;
    private double met;
    private String pin;
    private List<ServiceTicketInfo> serviceTicketInfoList;

    public String getEnrolleeId() {
        return enrolleeId;
    }

    public void setEnrolleeId(String enrolleeId) {
        this.enrolleeId = enrolleeId;
    }

    public String getEnrolleeName() {
        return enrolleeName;
    }

    public void setEnrolleeName(String enrolleeName) {
        this.enrolleeName = enrolleeName;
    }

    public double getDeductible() {
        return deductible;
    }

    public void setDeductible(double deductible) {
        this.deductible = deductible;
    }

    public double getMet() {
        return met;
    }

    public void setMet(double met) {
        this.met = met;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<ServiceTicketInfo> getServiceTicketInfoList() {
        return serviceTicketInfoList;
    }

    public void setServiceTicketInfoList(List<ServiceTicketInfo> serviceTicketInfoList) {
        this.serviceTicketInfoList = serviceTicketInfoList;
    }
}
