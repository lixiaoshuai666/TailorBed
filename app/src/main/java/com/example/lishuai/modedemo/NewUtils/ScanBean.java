package com.example.lishuai.modedemo.NewUtils;

import java.io.Serializable;

/**
 * 扫码后生成的数据bean
 */
public class ScanBean implements Serializable {
    private int theoryLength;//理论长度
    private double theoryFabricWidth;//理论幅宽
    private double actualFabricWidth;//实际幅宽
    private String lotNumber;//布批号
    private String reelNumber;//卷号
    private String fabricCode;//布料编码
    private boolean isSelect = true;
    private int spreadingId;//保存后生成的id

    public int getSpreadingId() {
        return spreadingId;
    }

    public void setSpreadingId(int spreadingId) {
        this.spreadingId = spreadingId;
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
            if (equalInt(this.reelNumber, other.reelNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(reelNumber);
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
