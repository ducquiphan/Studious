package com.studious.DAO;

import com.studious.entity.Test;
import com.studious.entity.TestReport;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class TestReportDAO extends StudiousDAO<TestReport, String> {

    final String INSERT_SQL = "INSERT INTO BAOCAOBAITHI(MaBCBT, MaBT, MaHS, Diem, ThoiGianHoanThanh, SLDung) VALUES (?,?,?,?,?,?)";
    final String DELETE_SQL = "DELETE FROM BAOCAOBAITHI WHERE MaBT = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAOCAOBAITHI";
    final String SELECTBYID_SQL = "SELECT * FROM BAOCAOBAITHI WHERE MaBT = ?";

    @Override
    public void insert(TestReport entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTestReportID(), entity.getTestID(),
                entity.getStudentID(), entity.getTestScore(),
                entity.getCompleteTime(), entity.getCorrectAnswers());
    }

    @Override
    public void update(TestReport entity) {
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<TestReport> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public TestReport selectById(String key) {
        List<TestReport> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TestReport> selectSql(String Sql, Object... args) {
        List<TestReport> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                TestReport entity = new TestReport();
                entity.setTestReportID(rs.getString(1));
                entity.setTestID(rs.getString(2));
                entity.setStudentID(rs.getString(3));
                entity.setTestScore(rs.getDouble(4));
                entity.setCompleteTime(rs.getInt(5));
                entity.setCorrectAnswers(rs.getInt(6));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
