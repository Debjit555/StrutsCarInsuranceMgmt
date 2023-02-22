/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

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
 * @author hp
 */
public class OfficerService {

    public static Officer getOfficer(String officerEmail) {

        Officer officer = new Officer();

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from officers where officerEmail=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, officerEmail);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(preparedStatement);

            while (rs.next()) {

                officer.setOfficerName(rs.getString("officerName"));
                officer.setOfficerEmail(rs.getString("officerEmail"));
                officer.setOfficerPassword(rs.getString("officerPassword"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return officer;
    }

    public static ArrayList getAllUsers() {
        ArrayList userList = new ArrayList();
        String sql = "SELECT  fnol_id,user_id,driverName,accident_type,fnol_status,claim_status FROM fnol WHERE fnol_status='APPROVED'";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
            Logger log = Logger.getLogger(OfficerService.class.getName());
            log.error("Error in Underwriter Service");
        }
        System.err.println("Total rows:" + userList.size());
        return userList;
    }

    public static Officer getUser(int fnol_id) {
        Officer user = new Officer();
        String sql = "SELECT  fnol_id,user_id,driverName,accident_type,fnol_status,claim_status FROM fnol WHERE fnol_id=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, fnol_id);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);

            while (rs.next()) {

                user.setFnol_id(rs.getInt("fnol_id"));
                user.setUser_id(rs.getInt("user_id"));
                user.setDriverName(rs.getString("driverName"));
                user.setAccident_type(rs.getString("accident_type"));
                user.setFnol_status(rs.getString("fnol_status"));
                user.setClaim_status(rs.getInt("claim_status"));

            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error("Error in Underwriter Service");
        }

        return user;
    }

}
