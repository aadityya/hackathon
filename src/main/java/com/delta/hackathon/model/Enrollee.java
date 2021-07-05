package com.delta.hackathon.model;


public class Enrollee {
    private String enrolleeId;
    private String enrolleeName;
    private double deductible;
    private double individualRemainingDeductible;
    private double familyRemainingDeductible;

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

    public double getIndividualRemainingDeductible() {
        return individualRemainingDeductible;
    }

    public void setIndividualRemainingDeductible(double individualRemainingDeductible) {
        this.individualRemainingDeductible = individualRemainingDeductible;
    }

    public double getFamilyRemainingDeductible() {
        return familyRemainingDeductible;
    }

    public void setFamilyRemainingDeductible(double familyRemainingDeductible) {
        this.familyRemainingDeductible = familyRemainingDeductible;
    }
}
