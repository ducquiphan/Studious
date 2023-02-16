
package com.studious.entity;

import java.util.Date;

/**
 *
 * @author Phan Qui Duc
 */
public class Lesson {
    private int lessonID;
    private String lessonName;
    private String subject;
    private int grade;
    private Date dateCreated;
    private String teacherID;

    public Lesson() {
    }

    public Lesson(int lessonID, String lessonName, String subject, int grade, Date dateCreated, String teacherID) {
        this.lessonID = lessonID;
        this.lessonName = lessonName;
        this.subject = subject;
        this.grade = grade;
        this.dateCreated = dateCreated;
        this.teacherID = teacherID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return getLessonName();
    }
    
}
