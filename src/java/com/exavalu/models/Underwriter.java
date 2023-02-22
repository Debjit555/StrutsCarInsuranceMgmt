/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.LoginService;
import com.exavalu.services.UnderwriterService;
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


public class Underwriter extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

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
    private String underwriterName;
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

    public String getUnderwriterName() {
        return underwriterName;
    }

    public void setUnderwriterName(String underwriterName) {
        this.underwriterName = underwriterName;
    }

    public String getFnol_status() {
        return fnol_status;
    }

    public void setFnol_status(String fnol_status) {
        this.fnol_status = fnol_status;
    }

   
    public String getUnderwriterPassword() {
        return underwriterPassword;
    }

    public void setUnderwriterPassword(String underwriterPassword) {
        this.underwriterPassword = underwriterPassword;
    }
    private String underwriterEmail;

    public String getUnderwriterEmail() {
        return underwriterEmail;
    }

    public void setUnderwriterEmail(String underwriterEmail) {
        this.underwriterEmail = underwriterEmail;
    }
    private String underwriterPassword;
    
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
    
//    public String doLoginUnderwriter() throws Exception {
//        String result = "FAILURE";
//
//        boolean success = LoginService.getInstance().doLoginUnderwriter(this);
//
//        if (success) {
//            System.out.println("returning Success from doLogin method");
//            
//            Underwriter underwriter = UnderwriterService.getUnderwriter(this.underwriterEmail);
//            
//            ArrayList underwriterList = UnderwriterService.getAllUsers();
//
//            sessionMap.put("Loggedin", underwriter);
//            sessionMap.put("LoggedinStatus", "Underwriter");
//            sessionMap.put("underwriterList", underwriterList);
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
