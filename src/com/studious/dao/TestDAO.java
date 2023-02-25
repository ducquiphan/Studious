package com.studious.dao;

import com.studious.entity.Test;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class TestDAO extends StudiousDAO<Test, String> {

    final String INSERT_SQL = "INSERT INTO BAITHI(MaBthi, TieuDe, ThoiGian, MonHoc, Khoi, MaGV) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE BAITHI SET TieuDe = ?, ThoiGian = ? MonHoc = ?, Khoi = ?, MaGV = ? WHERE MaBThi = ?";
    final String DELETE_SQL = "DELETE FROM BAITHI WHERE MaBThi = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAITHI";
    final String SELECTBYID_SQL = "SELECT * FROM BAITHI WHERE MaBThi = ?";
    final String SELECTBYSUBJECTGRADE_SQL = "SELECT * FROM BAITHI WHERE MonHoc = ? AND Khoi = ?";
    final String SELECTBYSUBJECTANDTIME_SQL = "SELECT * FROM BAITHI WHERE MonHoc = ? AND ThoiGian = ?";

    @Override
    public void insert(Test entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTestID(), entity.getTestTitle(),
                entity.getTimeTest(),
                entity.getLesson(),
                entity.getGrade(),
                entity.getTeacherID());
    }

    @Override
    public void update(Test entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTestTitle(), entity.getTimeTest(),
                entity.getLesson(), entity.getGrade(),
                entity.getTestID());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Test> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Test selectById(String key) {
        List<Test> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Test> selectSql(String Sql, Object... args) {
        List<Test> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Test entity = new Test();
                entity.setTestID(rs.getString(1));
                entity.setTestTitle(rs.getString(2));
                entity.setTimeTest(rs.getInt(3));
                entity.setLesson(rs.getString(4));
                entity.setGrade(rs.getInt(5));
                entity.setCreateDate(rs.getDate(6));
                entity.setTeacherID(rs.getString(7));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Test> selectByGradeSubject(String grade, String subject) {
        return selectSql(SELECTBYSUBJECTGRADE_SQL, subject, grade);
    }

    public List<Test> selectBySubjectAndTime(String subject, Integer timeTest){
        return selectSql(SELECTBYSUBJECTANDTIME_SQL, subject, timeTest);
    }
    
    public List<Test> selectBtTestTitleAndSubjectAndTime(String testTitle, String subject, Integer timeTest){
        String sql = "SELECT * FROM BAITHI WHERE TieuDe LIKE N'%"+testTitle+"%' AND MonHoc = "+subject+" AND ThoiGian = "+timeTest;
        List<Test> list = selectSql(sql);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
