package com.studious.dao;

import com.studious.entity.QuestionOfTest;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class QuestionOfTestDAO extends StudiousDAO<QuestionOfTest, Integer> {

    final String INSERT_SQL = "INSERT INTO CAUHOIBAITHI(MaCH, MaBThi) VALUES (?,?)";
    final String DELETE_SQL = "DELETE FROM CAUHOIBAITHI WHERE MaCHBT = ? AND MaBThi = ";
    final String DELETEBYTESTID_SQL = "DELETE FROM CAUHOIBAITHI WHERE MaBThi = ";
    final String SELECTALL_SQL = "SELECT * FROM CAUHOIBAITHI";
    final String SELECTBYID_SQL = "SELECT * FROM CAUHOIBAITHI WHERE MaCHBT = ?";
    final String SELECTBYTESTID_SQL = "SELECT * FROM CAUHOIBAITHI WHERE MaBThi = ?";
    final String SELECTBYQUESTIONID_SQL = "SELECT * FROM CAUHOIBAITHI WHERE MaCH = ?";

    @Override

    public void insert(QuestionOfTest entity) {
        JdbcHelper.update(INSERT_SQL, entity.getQuestionID(),
                entity.getTestID());
    }

    @Override
    public void update(QuestionOfTest entity) {
    }

    @Override
    public void delete(Integer key) {

    }

    public void deleteSuppor(Integer key, String maBThi) {
        JdbcHelper.update(DELETE_SQL, key, maBThi);
    }

    public void deleteByTestID(String key) {
        JdbcHelper.update(DELETEBYTESTID_SQL, key);
    }

    @Override
    public List<QuestionOfTest> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public QuestionOfTest selectById(Integer key) {
        List<QuestionOfTest> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<QuestionOfTest> selectByTestId(String key) {
        List<QuestionOfTest> list = selectSql(SELECTBYTESTID_SQL, key);
        return list;
    }

    public List<QuestionOfTest> selectByQuestionID(Integer questionID) {
        List<QuestionOfTest> list = selectSql(SELECTBYQUESTIONID_SQL, questionID);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<QuestionOfTest> selectSql(String Sql, Object... args) {
        List<QuestionOfTest> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                QuestionOfTest entity = new QuestionOfTest();
                entity.setQuestionOfTestID(rs.getInt(1));
                entity.setQuestionID(rs.getInt(2));
                entity.setTestID(rs.getString(3));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
