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
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import org.apache.log4j.Logger;

public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

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
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userPassword, fnol_status;
    private int claim_status;

    public int getClaim_status() {
        return claim_status;
    }

    public void setClaim_status(int claim_status) {
        this.claim_status = claim_status;
    }

    public String getFnol_status() {
        return fnol_status;
    }

    public void setFnol_status(String fnol_status) {
        this.fnol_status = fnol_status;
    }
    private int user_id;
    private String driverName, accident_type;
    private int fnol_id;

    public int getFnol_id() {
        return fnol_id;
    }

    public void setFnol_id(int fnol_id) {
        this.fnol_id = fnol_id;
    }

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String addFnol() {
        String result = "FAILURE";

        boolean success;
//        ArrayList emp=EmployeeService.getInstance().getAllEmployees();
        success = UserService.addFnol(this);

        if (success) {
            System.out.println("returning Success from addFnol method");

//            sessionMap.put("empList",emp);
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from addFnol method");
        }

        return result;
    }

    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean successUser = LoginService.getInstance().doLogin(this);
        boolean successUnderwriter = LoginService.getInstance().doLoginUnderwriter(this);
        boolean successOfficer = LoginService.getInstance().doLoginOfficer(this);

        if (successUser) {
            System.out.println("returning Success from doLogin method");
            System.out.println("userEmail = " + this.userEmail);
            System.out.println("user Id = " + this.user_id);
            User user = UserService.getUser(this.userEmail);
            ArrayList userList = UserService.getAllUsers(user.user_id);
            ArrayList underwriterList = UnderwriterService.getAllUsers();

            sessionMap.put("Loggedin", user);
            sessionMap.put("LoggedinStatus", "User");
            sessionMap.put("userList", userList);
            sessionMap.put("underwriterList", underwriterList);

            result = "USER";
        } else if(successUnderwriter){
            System.out.println("returning Success from doLogin method");
            
            Underwriter underwriter = UnderwriterService.getUnderwriter(this.userEmail);
            
            ArrayList underwriterList = UnderwriterService.getAllUsers();

            sessionMap.put("Loggedin", underwriter);
            sessionMap.put("LoggedinStatus", "Underwriter");
            sessionMap.put("underwriterList", underwriterList);

            result = "UNDERWRITER";
        }else if(successOfficer){
            System.out.println("returning Success from doLogin method");

            Officer officer = OfficerService.getOfficer(this.userEmail);
            
            ArrayList officerList = OfficerService.getAllUsers();

            sessionMap.put("Loggedin", officer);
            sessionMap.put("LoggedinStatus", "Officer");
            sessionMap.put("officerList", officerList);

            result = "OFFICER";
        }
        else{
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now() + "--Wrong email ID or password");
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }

    public String doSignUp() throws Exception {

        String result = "FAILURE";
        boolean success = LoginService.getInstance().doSignUp(this);

        if (success) {
            result = "SUCCESS";
            sessionMap.put("SuccessSignUp", "Successfully Registered");
            System.out.println("Returning from success");
        } else {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now() + "--Email Id already exists");
            sessionMap.put("FailSignUp", "Email address Already Exists");
            System.out.println("Returning from failure");
        }
        System.out.println(sessionMap);
        return result;

    }

    public String saveFnolStatus() throws Exception {
        String result = "FAILURE";

        boolean success = UserService.EditFnolStatus((int)sessionMap.get("FnolId"));
//        User user = UserService.getUser(userEmail);
//
//        sessionMap.put("User", user);

        if (success) {
            
            ArrayList underwriterList = UnderwriterService.getAllUsers();
            sessionMap.put("underwriterList", underwriterList);

            System.out.println("returning Success from Edit method");
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from Edit method");
        }

        return result;
    }
    public String saveFnolStatusReject() throws Exception {
        String result = "FAILURE";

        boolean success = UserService.EditFnolStatus((int)sessionMap.get("FnolId"));
//        User user = UserService.getUser(userEmail);
//
//        sessionMap.put("User", user);

        if (success) {
            
            ArrayList underwriterList = UnderwriterService.getAllUsers();
            sessionMap.put("underwriterList", underwriterList);

            System.out.println("returning Success from Edit method");
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from Edit method");
        }

        return result;
    }

    public String editFnol() throws Exception {
        String result = "SUCCESS";

//        boolean success = UserService.EditFnolStatus(this);
//        User user = UserService.getUser(userEmail);
        Underwriter underwriter = UnderwriterService.getUser(this.fnol_id);
        System.out.println(underwriter.getDriverName());
        sessionMap.put("FnolId", this.fnol_id);
        sessionMap.put("Underwriter", underwriter);

//        if (success) {
//            
//            System.out.println("returning Success from Edit method");
//            result = "SUCCESS";
//        } else {
//            System.out.println("returning Failure from Edit method");
//        }
        return result;
    }

    public String saveClaimStatus() throws Exception {
        String result = "FAILURE";

        boolean success = UserService.EditClaimStatus(this,this.fnol_id);
//        User user = UserService.getUser(userEmail);
//
//        sessionMap.put("User", user);

        if (success) {
            
            ArrayList officerList = OfficerService.getAllUsers();
            sessionMap.put("officerList", officerList);

            System.out.println("returning Success from Edit method");
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from Edit method");
        }

        return result;
    }

    public String editClaim() throws Exception {
        String result = "SUCCESS";

//        boolean success = UserService.EditFnolStatus(this);
//        User user = UserService.getUser(userEmail);
        Officer officer = OfficerService.getUser(this.fnol_id);
        System.out.println(officer.getDriverName());
//        sessionMap.put("User", user);
        sessionMap.put("Officer", officer);

//        if (success) {
//            
//            System.out.println("returning Success from Edit method");
//            result = "SUCCESS";
//        } else {
//            System.out.println("returning Failure from Edit method");
//        }
        return result;
    }

    public String doLogout() {
        String result = "SUCCESS";
        sessionMap.clear();
        return result;
    }

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
