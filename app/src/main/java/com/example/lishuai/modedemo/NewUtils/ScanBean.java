package com.example.lishuai.modedemo.NewUtils;

import java.io.Serializable;

/**
 * 扫码后生成的数据bean
 */
public class ScanBean implements Serializable {
    private int theoryLength;//理论长度
    private double theoryFabricWidth;//理论幅宽
    private double actualFabricWidth;//实际幅宽
    private String fLotNumber;//布批号
    private String fReelNumber;//卷号
    private String fFabricCode;//布料编码
    private boolean isSelect = true;

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

    public String getfLotNumber() {
        return fLotNumber;
    }

    public void setfLotNumber(String fLotNumber) {
        this.fLotNumber = fLotNumber;
    }

    public String getfReelNumber() {
        return fReelNumber;
    }

    public void setfReelNumber(String fReelNumber) {
        this.fReelNumber = fReelNumber;
    }

    public String getfFabricCode() {
        return fFabricCode;
    }

    public void setfFabricCode(String fFabricCode) {
        this.fFabricCode = fFabricCode;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof ScanBean) {
            ScanBean other = (ScanBean) obj;
            if (equalInt(this.fReelNumber, other.fReelNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(fReelNumber);
        char[] charArr = sb.toString().toCharArray();
        int hash = 0;

        for (char c : charArr) {
            hash = hash * 131 + c;
        }
        return hash;
    }

    private boolean equalInt(String i1, String i2) {
        return i1.equals(i2);
    }
}
