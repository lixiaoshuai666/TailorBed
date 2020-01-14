package com.example.lishuai.modedemo.NewUtils;

import com.example.lishuai.modedemo.BeasBean;

public class LoginDataBean extends BeasBean {


    /**
     * data : {"token":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDcyODA2Mzc4NzgwODg5MDkyIiwic3ViIjoiempjIiwiaWF0IjoxNTc4OTcyMTU1LCJyb2xlcyI6WyLmma7pgJrnlKjmiLciXSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6InBhZ2U6dGFpbG9yaW5nUGxhbnMifSx7ImF1dGhvcml0eSI6ImJ0bjp0ZXN0OnF1ZXJ5In1dLCJleHAiOjE1Nzk1NzY5NTV9.EALOUZpj5_331MC138DajRpqrlKi3XHU9t_8LZujmFo","tokenType":"Bearer"}
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
         * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDcyODA2Mzc4NzgwODg5MDkyIiwic3ViIjoiempjIiwiaWF0IjoxNTc4OTcyMTU1LCJyb2xlcyI6WyLmma7pgJrnlKjmiLciXSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6InBhZ2U6dGFpbG9yaW5nUGxhbnMifSx7ImF1dGhvcml0eSI6ImJ0bjp0ZXN0OnF1ZXJ5In1dLCJleHAiOjE1Nzk1NzY5NTV9.EALOUZpj5_331MC138DajRpqrlKi3XHU9t_8LZujmFo
         * tokenType : Bearer
         */

        private String token;
        private String tokenType;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }
    }
}
