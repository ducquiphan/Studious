package com.studious.entity;

import java.util.Date;

/**
 *
 * @author Phan Qui Duc
 */
public class Document {
    private int docID;
    private String docTitle;
    private String lesson;
    private String content;
    private Date creatDate;
    private String teacherID;
    private int lessonID;

    public Document(int docID, String docTitle, String lesson, String content, Date creatDate, String teacherID, int lessonID) {
        this.docID = docID;
        this.docTitle = docTitle;
        this.lesson = lesson;
        this.content = content;
        this.creatDate = creatDate;
        this.teacherID = teacherID;
        this.lessonID = lessonID;
    }

    public Document() {
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    @Override
    public String toString() {
        return "Document{" + "docID=" + docID + ", docTitle=" + docTitle + ", lesson=" + lesson + ", content=" + content + ", creatDate=" + creatDate + ", teacherID=" + teacherID + ", lessonID=" + lessonID + '}';
    }
}
