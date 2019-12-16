package com.example.lishuai.modedemo;

/**
 * 效验扫一扫的接口
 */
public class EfficacyBean extends BeasBean{


    /**
     * data : {"resultType":12,"id":91}
     */

    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * resultType : 12
         * id : 91
         */

        private int resultType;
        private int id;

        public int getResultType() {
            return resultType;
        }

        public void setResultType(int resultType) {
            this.resultType = resultType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
