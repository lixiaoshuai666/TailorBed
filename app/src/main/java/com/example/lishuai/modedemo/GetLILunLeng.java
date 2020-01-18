package com.example.lishuai.modedemo;

import java.io.Serializable;
import java.util.List;

public class GetLILunLeng extends BeasBean implements Serializable {


    /**
     * data : {"theoryLength":12,"fagEndList":[{"theoryLength":1,"theoryFabricWidth":1.32,"actualFabricWidth":1.32,"lotNumber":"2ddd","reelNumber":"12dddd","fabricCode":"223ddd","spreadingId":12},{"theoryLength":1,"theoryFabricWidth":1.32,"actualFabricWidth":1.32,"lotNumber":"2ddd","reelNumber":"12dddd","fabricCode":"223ddd","spreadingId":12}]}
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
         * theoryLength : 12
         * fagEndList : [{"theoryLength":1,"theoryFabricWidth":1.32,"actualFabricWidth":1.32,"lotNumber":"2ddd","reelNumber":"12dddd","fabricCode":"223ddd","spreadingId":12},{"theoryLength":1,"theoryFabricWidth":1.32,"actualFabricWidth":1.32,"lotNumber":"2ddd","reelNumber":"12dddd","fabricCode":"223ddd","spreadingId":12}]
         */

        private int theoryLength;
        private int type;//布料的类型，布头，报废
        private List<FagEndListBean> fagEndList;

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

        public List<FagEndListBean> getFagEndList() {
            return fagEndList;
        }

        public void setFagEndList(List<FagEndListBean> fagEndList) {
            this.fagEndList = fagEndList;
        }

    }
}
