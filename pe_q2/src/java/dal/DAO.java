/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author vuhai
 */
public class DAO extends DBContext{
    public ArrayList<Student> searchAllStudent(String name){
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select stuid, stuname, stugender, studob from Student where stuname like '%"+name+"%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                students.add(new Student(rs.getInt("stuid"), rs.getString("stuname"), rs.getBoolean("stugender"), rs.getDate("studob").toLocalDate(), ""));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return students;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        ArrayList<Student> students = dao.searchAllStudent("stu");
        for (Student student : students) {
            System.out.println(student.getStuname());
        }
        
    }
}
