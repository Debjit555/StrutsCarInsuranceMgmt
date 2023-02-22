/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


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
 * @author hp
 */
public class UserService {

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static boolean addFnol(User fnol) {
        boolean result = false;
        String sql = "INSERT INTO fnol"
                + "(driverName,\n"
                + "accident_type,\n"
                + "fnol_status,\n"
                + "claim_status,\n"
                + "user_id)\n"
                + "VALUES\n"
                + "(?,?,?,?,?);";

        try {
            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, fnol.getDriverName());
            preparedStatement.setString(2, fnol.getAccident_type());
            preparedStatement.setString(3, "PENDING");
            preparedStatement.setInt(4, 0);
            preparedStatement.setInt(5, fnol.getUser_id());
            
            System.out.println(preparedStatement);
            System.out.println(sql);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static User getUser(String userEmail) {
        User user = new User();
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from users where userEmail=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userEmail);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(preparedStatement);

            while (rs.next()) {

                user.setUser_id(rs.getInt("user_id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserEmail(rs.getString("userEmail"));
                user.setUserPassword(rs.getString("userPassword"));
              

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }
    
    public static boolean EditFnolStatus(int fnol_id) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE fnol\n"
                    + "SET fnol_status = ? WHERE fnol_id=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "APPROVED");
            preparedStatement.setInt(2, fnol_id);
            
            System.out.println(preparedStatement);

            int row = preparedStatement.executeUpdate();
            

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static boolean EditFnolStatusReject(int fnol_id) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE fnol\n"
                    + "SET fnol_status = ? WHERE fnol_id=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "APPROVED");
            preparedStatement.setInt(2, fnol_id);
            
            System.out.println(preparedStatement);

            int row = preparedStatement.executeUpdate();
            

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static boolean EditClaimStatus(User user,int fnol_id) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE fnol\n"
                    + "SET claim_status = ? WHERE fnol_id=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, user.getClaim_status());
            preparedStatement.setInt(2, fnol_id);
            
            System.out.println(preparedStatement);

            int row = preparedStatement.executeUpdate();
            

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
       
    public static ArrayList getAllUsers(int user_id) {
        System.out.println("User ID - "+user_id);
        ArrayList userList = new ArrayList();
        String sql = "SELECT  fnol_id,user_id,driverName,accident_type,fnol_status,claim_status FROM fnol WHERE user_id=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            System.out.println(ps);

            while (rs.next()) {
                User user = new User();

                user.setFnol_id(rs.getInt("fnol_id"));
                user.setUser_id(rs.getInt("user_id"));
                user.setDriverName(rs.getString("driverName"));
                user.setAccident_type(rs.getString("accident_type"));
                user.setFnol_status(rs.getString("fnol_status"));
                user.setClaim_status(rs.getInt("claim_status"));
                

                userList.add(user);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error("Error in User Service");
        }
        System.err.println("Total rows:" + userList.size());
        return userList;
    }
    
}
