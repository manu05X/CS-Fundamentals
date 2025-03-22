package com.manish.LLD.Parkinglot.models;

public class Gate extends BaseModel {
    private int gateNumber;
    private GateStatus gateStatus;
    private GateType gateType;
    private Operator currentOperator;

    public int getGateNumber() {
        return gateNumber;
    }
    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }
    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }
    public void setGateType(GateType gateType) {}

    public Operator getCurrentOperator() {
        return currentOperator;
    }
}
