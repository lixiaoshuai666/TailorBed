package com.example.lishuai.modedemo;

import java.io.Serializable;

public class FagEndListBean implements Serializable {

    /**
     * theoryLength : 1
     * theoryFabricWidth : 1.32
     * actualFabricWidth : 1.32
     * lotNumber : 2ddd
     * reelNumber : 12dddd
     * fabricCode : 223ddd
     * spreadingId : 12
     */

    private int theoryLength;
    private double theoryFabricWidth;
    private double actualFabricWidth;
    private String lotNumber;
    private String reelNumber;
    private String fabricCode;
    private int spreadingId;
    private int type;//报废2，布头1

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTheoryLength() {
        return theoryLength;
    }

    public void setTheoryLength(int theoryLength) {
        this.theoryLength = theoryLength;
    }

    public double getTheoryFabricWidth() {
        return theoryFabricWidth;
    }

    public void setTheoryFabricWidth(double theoryFabricWidth) {
        this.theoryFabricWidth = theoryFabricWidth;
    }

    public double getActualFabricWidth() {
        return actualFabricWidth;
    }

    public void setActualFabricWidth(double actualFabricWidth) {
        this.actualFabricWidth = actualFabricWidth;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getReelNumber() {
        return reelNumber;
    }

    public void setReelNumber(String reelNumber) {
        this.reelNumber = reelNumber;
    }

    public String getFabricCode() {
        return fabricCode;
    }

    public void setFabricCode(String fabricCode) {
        this.fabricCode = fabricCode;
    }

    public int getSpreadingId() {
        return spreadingId;
    }

    public void setSpreadingId(int spreadingId) {
        this.spreadingId = spreadingId;
    }
}
