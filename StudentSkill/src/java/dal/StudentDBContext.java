/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Student;

/**
 *
 * @author Ngo Tung Son
 */
public class StudentDBContext extends DBContext<Student> {

    @Override
    public void insert(Student model) {
        try {
            String sql = "INSERT INTO [Student]\n"
                    + "           ([sname]\n"
                    + "           ,[gender]\n"
                    + "           ,[dob]\n"
                    + "           ,[created_time]\n"
                    + "           ,[did])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,GETDATE()\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setBoolean(2, model.isGender());
            stm.setDate(3, model.getDob());
            stm.setInt(4, model.getDept().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Student model) {
        try {
            String sql = "UPDATE [Student]\n"
                    + "   SET [sname] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[did] = ?\n"
                    + " WHERE [sid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setBoolean(2, model.isGender());
            stm.setDate(3, model.getDob());
            stm.setInt(4, model.getDept().getId());
            stm.setInt(5, model.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Student model) {
        try {
            String sql = "DELETE Student\n"
                    + " WHERE [sid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Student get(int id) {
        try {
            String sql = "SELECT s.sid,s.sname,s.gender,s.dob,s.created_time,d.did,d.dname FROM Student s INNER JOIN Department d ON s.did = d.did\n"
                    + "WHERE s.sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                boolean gender = rs.getBoolean("gender");
                Date dob = rs.getDate("dob");
                Timestamp timestamp = rs.getTimestamp("created_time");
                java.util.Date created_time
                        = new java.util.Date(timestamp.getTime());
                s.setId(sid);
                s.setName(sname);
                s.setGender(gender);
                s.setDob(dob);
                s.setCreated_time(created_time);
                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                s.setDept(d);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT [sid],sname,gender,dob,created_time FROM Student";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                boolean gender = rs.getBoolean("gender");
                Date dob = rs.getDate("dob");
                Timestamp timestamp = rs.getTimestamp("created_time");
                java.util.Date created_time
                        = new java.util.Date(timestamp.getTime());
                s.setId(sid);
                s.setName(sname);
                s.setGender(gender);
                s.setDob(dob);
                s.setCreated_time(created_time);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

}
