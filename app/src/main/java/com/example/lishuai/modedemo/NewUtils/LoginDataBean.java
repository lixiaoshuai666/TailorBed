package com.example.lishuai.modedemo.NewUtils;

import com.example.lishuai.modedemo.BeasBean;

import java.io.Serializable;
import java.util.List;

public class LoginDataBean extends BeasBean {


    /**
     * data : {"token":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDcyODA2Mzc4NzgwODg5MDkyIiwic3ViIjoiempjIiwiaWF0IjoxNTc5MTU5Njk1LCJyb2xlcyI6WyLmma7pgJrnlKjmiLciXSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6ImJ0bjphcGk6dGFpbG9yaW5nUGxhbnMifSx7ImF1dGhvcml0eSI6ImJ0bjp0YWlsb3JpbmdQbGFucyJ9LHsiYXV0aG9yaXR5IjoiYnRuOnRhaWxvcmluZyJ9LHsiYXV0aG9yaXR5IjoiYnRuOmF1dGg6bG9nb3V0In0seyJhdXRob3JpdHkiOiJidG46dGFpbG9yaW5nIn1dLCJleHAiOjE1Nzk3NjQ0OTV9.Ta1t8iIxj3rDXJBYRp7M0FPIaWn4iDQjiRat9aZpcc8","tokenType":"Bearer","groups":[{"id":2,"createTime":"2020-01-13 11:02","updateTime":"2020-01-13 11:02","createdBy":"1544611947032","updatedBy":"1544611947032","team":"F1组\r\n","teamMan":"吴治崟,郑金成","teamType":"裁剪","status":"0"}]}
     */

    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity implements Serializable {
        /**
         * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDcyODA2Mzc4NzgwODg5MDkyIiwic3ViIjoiempjIiwiaWF0IjoxNTc5MTU5Njk1LCJyb2xlcyI6WyLmma7pgJrnlKjmiLciXSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6ImJ0bjphcGk6dGFpbG9yaW5nUGxhbnMifSx7ImF1dGhvcml0eSI6ImJ0bjp0YWlsb3JpbmdQbGFucyJ9LHsiYXV0aG9yaXR5IjoiYnRuOnRhaWxvcmluZyJ9LHsiYXV0aG9yaXR5IjoiYnRuOmF1dGg6bG9nb3V0In0seyJhdXRob3JpdHkiOiJidG46dGFpbG9yaW5nIn1dLCJleHAiOjE1Nzk3NjQ0OTV9.Ta1t8iIxj3rDXJBYRp7M0FPIaWn4iDQjiRat9aZpcc8
         * tokenType : Bearer
         * groups : [{"id":2,"createTime":"2020-01-13 11:02","updateTime":"2020-01-13 11:02","createdBy":"1544611947032","updatedBy":"1544611947032","team":"F1组\r\n","teamMan":"吴治崟,郑金成","teamType":"裁剪","status":"0"}]
         */

        private String token;
        private String tokenType;
        private List<GroupsEntity> groups;

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

        public List<GroupsEntity> getGroups() {
            return groups;
        }

        public void setGroups(List<GroupsEntity> groups) {
            this.groups = groups;
        }

        public static class GroupsEntity implements Serializable {
            /**
             * id : 2
             * createTime : 2020-01-13 11:02
             * updateTime : 2020-01-13 11:02
             * createdBy : 1544611947032
             * updatedBy : 1544611947032
             * team : F1组
             * teamMan : 吴治崟,郑金成
             * teamType : 裁剪
             * status : 0
             */

            private int id;
            private String createTime;
            private String updateTime;
            private String createdBy;
            private String updatedBy;
            private String team;
            private String teamMan;
            private String teamType;
            private String status;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getCreatedBy() {
                return createdBy;
            }

            public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
            }

            public String getUpdatedBy() {
                return updatedBy;
            }

            public void setUpdatedBy(String updatedBy) {
                this.updatedBy = updatedBy;
            }

            public String getTeam() {
                return team;
            }

            public void setTeam(String team) {
                this.team = team;
            }

            public String getTeamMan() {
                return teamMan;
            }

            public void setTeamMan(String teamMan) {
                this.teamMan = teamMan;
            }

            public String getTeamType() {
                return teamType;
            }

            public void setTeamType(String teamType) {
                this.teamType = teamType;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
