package com.example.lishuai.modedemo;


import java.io.Serializable;
import java.util.List;

public class UnfinishedBean extends BeasBean  {


    private List<UnfinishedItemBean> data;

    public List<UnfinishedItemBean> getData() {
        return data;
    }

    public void setData(List<UnfinishedItemBean> data) {
        this.data = data;
    }

    public static class UnfinishedItemBean implements Serializable {
        /**
         * id : 1
         * workOrderNo : 1
         * status : 1
         * typeNumber : 1
         * group : 1
         * member : 1,1,1
         * mainSupplement : 补
         * quantity : 1
         * dueDate : 2019-11-02T20:38:36.000+0000
         * productLineNo : 1
         * productCode : 1
         * fabricCode : 1
         * fabricWidth : 0.99幅宽
         * fabricColour : 1
         * boxQuantity : 1
         * bindingQuantity : 3
         * changePiecesQuantity : 5
         * maxQuantity : 1
         * maxChangePiecesQuantity : 5
         * isSelect: true
         */

        private int id;
        private String workOrderNo;
        private String status;
        private String typeNumber;
        private String group;
        private String member;
        private String mainSupplement;
        private int quantity;//件数
        private String dueDate;
        private int productLineNo;
        private String productCode;
        private String fabricCode;
        private double fabricWidth;
        private String fabricColour;
        private int boxQuantity;
        private int bindingQuantity;
        private int changePiecesQuantity;
        private int maxQuantity;
        private int maxChangePiecesQuantity;
        private boolean isSelect;
        private int floor;//层高
        private String typeGroup="";//版形
        private int typeQuantity;//本次裁剪件数

        public int getTypeQuantity() {
            return typeQuantity;
        }

        public void setTypeQuantity(int typeQuantity) {
            this.typeQuantity = typeQuantity;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public String getTypeGroup() {
            return typeGroup;
        }

        public void setTypeGroup(String typeGroup) {
            this.typeGroup = typeGroup;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getWorkOrderNo() {
            return workOrderNo;
        }

        public void setWorkOrderNo(String workOrderNo) {
            this.workOrderNo = workOrderNo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTypeNumber() {
            return typeNumber;
        }

        public void setTypeNumber(String typeNumber) {
            this.typeNumber = typeNumber;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getMember() {
            return member;
        }

        public void setMember(String member) {
            this.member = member;
        }

        public String getMainSupplement() {
            return mainSupplement;
        }

        public void setMainSupplement(String mainSupplement) {
            this.mainSupplement = mainSupplement;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public int getProductLineNo() {
            return productLineNo;
        }

        public void setProductLineNo(int productLineNo) {
            this.productLineNo = productLineNo;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getFabricCode() {
            return fabricCode;
        }

        public void setFabricCode(String fabricCode) {
            this.fabricCode = fabricCode;
        }

        public double getFabricWidth() {
            return fabricWidth;
        }

        public void setFabricWidth(double fabricWidth) {
            this.fabricWidth = fabricWidth;
        }

        public String getFabricColour() {
            return fabricColour;
        }

        public void setFabricColour(String fabricColour) {
            this.fabricColour = fabricColour;
        }

        public int getBoxQuantity() {
            return boxQuantity;
        }

        public void setBoxQuantity(int boxQuantity) {
            this.boxQuantity = boxQuantity;
        }

        public int getBindingQuantity() {
            return bindingQuantity;
        }

        public void setBindingQuantity(int bindingQuantity) {
            this.bindingQuantity = bindingQuantity;
        }

        public int getChangePiecesQuantity() {
            return changePiecesQuantity;
        }

        public void setChangePiecesQuantity(int changePiecesQuantity) {
            this.changePiecesQuantity = changePiecesQuantity;
        }

        public int getMaxQuantity() {
            return maxQuantity;
        }

        public void setMaxQuantity(int maxQuantity) {
            this.maxQuantity = maxQuantity;
        }

        public int getMaxChangePiecesQuantity() {
            return maxChangePiecesQuantity;
        }

        public void setMaxChangePiecesQuantity(int maxChangePiecesQuantity) {
            this.maxChangePiecesQuantity = maxChangePiecesQuantity;
        }
    }
}
