/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.LoginService;
import com.exavalu.services.OfficerService;
import com.exavalu.services.UnderwriterService;
import com.exavalu.services.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class Officer extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }
    /**
     * @param args the command line arguments
     */
    private String officerName;
    private String fnol_status;
    private int fnol_id,user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFnol_id() {
        return fnol_id;
    }

    public void setFnol_id(int fnol_id) {
        this.fnol_id = fnol_id;
    }

    public String getFnol_status() {
        return fnol_status;
    }

    public void setFnol_status(String fnol_status) {
        this.fnol_status = fnol_status;
    }
    private String officerEmail;
    private String officerPassword;
    private int claim_status;

    public int getClaim_status() {
        return claim_status;
    }

    public void setClaim_status(int claim_status) {
        this.claim_status = claim_status;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficerEmail() {
        return officerEmail;
    }

    public void setOfficerEmail(String officerEmail) {
        this.officerEmail = officerEmail;
    }

    public String getOfficerPassword() {
        return officerPassword;
    }

    public void setOfficerPassword(String officerPassword) {
        this.officerPassword = officerPassword;
    }

    private String driverName, accident_type;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getAccident_type() {
        return accident_type;
    }

    public void setAccident_type(String accident_type) {
        this.accident_type = accident_type;
    }

    public static com.opensymphony.xwork2.util.logging.Logger getLOG() {
        return LOG;
    }

    public static void setLOG(com.opensymphony.xwork2.util.logging.Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }

//    public String doLoginOfficer() throws Exception {
//        String result = "FAILURE";
//
//        boolean success = LoginService.getInstance().doLoginOfficer(this);
//
//        if (success) {
//            System.out.println("returning Success from doLogin method");
//
//            Officer officer = OfficerService.getOfficer(this.officerEmail);
//            
//            ArrayList officerList = OfficerService.getAllUsers();
//
//            sessionMap.put("Loggedin", officer);
//            sessionMap.put("LoggedinStatus", "Officer");
//            sessionMap.put("officerList", officerList);
//
//            result = "SUCCESS";
//        } else {
//            Logger log = Logger.getLogger(LoginService.class.getName());
//            log.error(LocalDateTime.now() + "--Wrong email ID or password");
//            System.out.println("returning Failure from doLoginUnderwriter method");
//        }
//
//        return result;
//    }

//    public String apiCall() throws Exception {
//        String result = "SUCCESS";
//        ArrayList userList=ApiService.getInstance().getAllData();
//        boolean success = LoginService.getInstance().doSignUpAll(userList);
//
//        if (success) {
//            result = "SUCCESS";
//            sessionMap.put("SuccessSignUp", "Successfully Registered");
//
//        } else {
//            sessionMap.put("FailSignUp", "Email All Ready Exsists");
//        }
//        System.out.println(sessionMap);
//        return result;
//
//    }
}
