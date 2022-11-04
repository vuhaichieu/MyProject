/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;
import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 *
 * @author vuhai
 */
public class DAO extends DBContext{
    public Account check(String username,String password){
        String sql ="select * from Account where username=? and password=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new  Account(username,password, null);
            }
        } catch (Exception e) {
        }
        return null;
    }   
}
