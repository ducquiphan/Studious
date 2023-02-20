package com.studious.DAO;

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

    final String INSERT_SQL = "INSERT INTO BAITHI(MaBThi, TieuDe, MonHoc, Khoi, NgayTao, MaGV, DanhSachMaCHBT) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE BAITHI SET TieuDe = ?, MonHoc = ?, Khoi = ?, NgayTao = ?, MaGV = ?, DanhSachMaCHBT = ? WHERE MaBThi = ?";
    final String DELETE_SQL = "DELETE FROM BAITHI WHERE MaBThi = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAITHI";
    final String SELECTBYID_SQL = "SELECT * FROM BAITHI WHERE MaBThi = ?";

    @Override
    public void insert(Test entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTestID(), entity.getTestTitle(),
                entity.getLesson(), entity.getGrade(),
                entity.getCreateDate(), entity.getTeacherID(),
                entity.getQuestionsList());
    }

    @Override
    public void update(Test entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTestTitle(),
                entity.getLesson(), entity.getGrade(),
                entity.getCreateDate(), entity.getTeacherID(),
                entity.getQuestionsList(), entity.getTestID());
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
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                Test entity = new Test();
                entity.setTestID(rs.getString(1));
                entity.setTestTitle(rs.getString(2));
                entity.setLesson(rs.getString(3));
                entity.setGrade(rs.getInt(4));
                entity.setCreateDate(rs.getDate(5));
                entity.setTeacherID(rs.getString(6));
                entity.setQuestionsList(rs.getString(7));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
