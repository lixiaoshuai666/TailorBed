package com.example.lishuai.modedemo;

public class RequestUrl {
    //请求地址前缀
//    private static final String MY_HTTP_URL="http://198.181.43.41/";
    private static final String MY_HTTP_URL="http://39.98.239.104:8182/";
//    private static final String MY_HTTP_URL="http://xiaapp1:8182/";


    public static final String listForPda=MY_HTTP_URL+"tailoringPlans/listForPda";

    public static final String fabricCodes=MY_HTTP_URL+"tailoringPlans/fabricCodes";

    public static final String  checkDetail =MY_HTTP_URL+"api/tailoringTask/createTask";//扫码按钮的数据判断

    public static final String  detail =MY_HTTP_URL+"api/tailoringTask/spreading";//保存接口

    public static final String  toFabricLeft =MY_HTTP_URL+"tailoring/toFabricLeft";//删除扫码信息到布头表

    public static final String  examine =MY_HTTP_URL+"tailoring/examine";//提交给车间主任审核

    public static final String  fabricLeftTheoryLength =MY_HTTP_URL+"tailoring/fabricLeftTheoryLength?reelNumber=";//查询理论长度

    public static final String  login =MY_HTTP_URL+"api/auth/login";//登陆接口





}
