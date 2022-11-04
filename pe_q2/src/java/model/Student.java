/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author vuhai
 */
public class Student {
    private int stuid;
    private  String stuname;
    private boolean stugender;
    private LocalDate studob;
    private String createdby;

    public Student() {
    }

    public Student(int stuid, String stuname, boolean stugender, LocalDate studob, String createdby) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stugender = stugender;
        this.studob = studob;
        this.createdby = createdby;
    }

    
    
    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public boolean isStugender() {
        return stugender;
    }

    public void setStugender(boolean stugender) {
        this.stugender = stugender;
    }

    public LocalDate getStudob() {
        return studob;
    }

    public void setStudob(LocalDate studob) {
        this.studob = studob;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
    
    
}
