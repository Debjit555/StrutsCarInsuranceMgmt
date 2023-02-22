/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

//import com.exavalu.models.Country;
//import com.exavalu.models.District;
//import com.exavalu.models.Province;
import com.exavalu.models.Officer;
import com.exavalu.models.Underwriter;
import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class LoginService {

    public static LoginService loginService = null;

//    public static ArrayList getAllStates(String countryCode) {
//
//        ArrayList stateList = new ArrayList();
//        Connection con = JDBCConnectionManager.getConnection();
//
//        try {
//
//            String sql = "Select * from states where countryCode = ?";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1, countryCode);
//            System.err.println(countryCode);
//            System.err.println(sql);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                Province province = new Province();
//                province.setCountryCode(rs.getString("countryCode"));
//                province.setProvinceName(rs.getString("stateName"));
//                province.setProvinceCode(rs.getString("stateCode"));
//                stateList.add(province);
//            }
//        } catch (SQLException ex) {
//
//            ex.printStackTrace();
//        }
//
//        return stateList;
//
//    }

//    public static ArrayList getAllDistricts(String stateCode) {
//
//        ArrayList distList = new ArrayList();
//        Connection con = JDBCConnectionManager.getConnection();
//
//        try {
//
//            String sql = "Select * from districts where stateCode = ?";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1, stateCode);
//
//            System.err.println(stateCode);
//            System.err.println(sql);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                District dist = new District();
//                dist.setDistCode(rs.getString("districtCode"));
//                dist.setDistName(rs.getString("districtName"));
//                dist.setProvinceCode(rs.getString("stateCode"));
//                distList.add(dist);
//            }
//        } catch (SQLException ex) {
//
//            ex.printStackTrace();
//        }
//
//        return distList;
//
//    }

    private LoginService() {
    }

    public static LoginService getInstance() {
        if (loginService == null) {
            return new LoginService();
        } else {
            return loginService;
        }
    }

    public boolean doLogin(User user) {
        boolean success = false;

        String sql = "Select * from users where userEmail=? and userPassword=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserEmail());
            ps.setString(2, user.getUserPassword());

            System.out.println("LoginService :: " + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                success = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error in Login Service");
//            ex.printStackTrace();
        }

        return success;
    }
    
    public boolean doLoginUnderwriter(User underwriter) {
        boolean success = false;

        String sql = "Select * from underwriters where underwriterEmail=? and underwriterPassword=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, underwriter.getUserEmail());
            ps.setString(2, underwriter.getUserPassword());

            System.out.println("LoginService :: " + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                success = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error in Login Service");
//            ex.printStackTrace();
        }

        return success;
    }

//    public static ArrayList getAllCountries() {
//
//        ArrayList countryList = new ArrayList();
//        Connection con = JDBCConnectionManager.getConnection();
//
//        try {
//
//            String sql = "Select * from countries";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//            System.err.println(sql);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                Country country = new Country();
//                country.setCountryCode(rs.getString("countryCode"));
//                country.setCountryName(rs.getString("countryName"));
//                countryList.add(country);
//            }
//        } catch (SQLException ex) {
//
//        }
//
//        return countryList;
//
//    }

    public boolean doSignUp(User user) {
        boolean result = false;
        String sql = "INSERT INTO users(userEmail,userPassword,firstName,lastName)" + "VALUES(? ,? ,? ,?)";

        try {
            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserEmail());
            preparedStatement.setString(2, user.getUserPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            
            System.out.println("SQL= " + sql);
            System.out.println(preparedStatement);
            int res = preparedStatement.executeUpdate();

            if (res == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            int e = ex.getErrorCode();
            System.out.println(e);
        }

        return result;

    }

    public boolean doSignUpAll(ArrayList userList) {
        boolean result = true;
        for(int i=0;i<userList.size();i++)
        {
            if(!doSignUp((User)userList.get(i)))
            {
                result=false;
            }
        }
        return result;
    }

    public boolean doLoginOfficer(User officer) {
        boolean success = false;

        String sql = "Select * from officers where officerEmail=? and officerPassword=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, officer.getUserEmail());
            ps.setString(2, officer.getUserPassword());

            System.out.println("LoginService :: " + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                success = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error in Login Service");
//            ex.printStackTrace();
        }

        return success;
    }
        
    }


