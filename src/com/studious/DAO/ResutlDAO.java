package com.studious.DAO;

import com.studious.entity.Result;
import com.studious.entity.Test;
import com.studious.ultils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class ResutlDAO extends StudiousDAO<Result, Integer> {

    final String INSERT_SQL = "INSERT INTO KETQUA(MaLanThi, MaHS, MaBTHI, MaCau, DanAnChon, DanAnDung) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KETQUA SET DanAnChon = ? WHERE (MaLanThi = ? AND MaHS = ? AND MaBTHI = ? AND MaCau = ?)";
    final String DELETE_SQL = "DELETE FROM KETQUA WHERE (MaLanThi = ? AND MaHS = ? AND MaBTHI = ? AND MaCau = ?)";
    final String SELECTALL_SQL = "SELECT * FROM KETQUA";
    final String SELECTBYID_SQL = "SELECT * FROM KETQUA WHERE (MaLanThi = ? AND MaHS = ? AND MaBTHI = ? AND MaCau = ?)";
    final String SELECTBYTESTSTUDENT = "SELECT MaLanThi, MaHS, MaBTHI FROM KETQUA WHERE (MaHS = ? AND MaBTHI = ?) GROUP BY MaHS, MaBTHI, MaLanThi ORDER BY MaLanThi DESC";
    final String SELECTBYINDEXTEST = "SELECT * FROM KETQUA WHERE (MaHS = ? AND MaBTHI = ? AND MaLanThi = ?) ";

    @Override
    public void insert(Result entity) {
        JdbcHelper.update(INSERT_SQL, entity.getIndexTest(),
                entity.getStudentID(), entity.getTestID(),
                entity.getIndexQuestion(), entity.getAnsSelected(),
                entity.getAnsCorrect());
    }

    @Override
    public void update(Result entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getAnsSelected(), entity.getIndexTest(),
                entity.getStudentID(), entity.getTestID(),
                entity.getIndexQuestion());
    }

    @Override
    public void delete(Integer key) {
        Result entity = selectById(key);
        deleteSupport(entity);
    }

    public void deleteSupport(Result entity) {
        JdbcHelper.update(DELETE_SQL, entity.getIndexTest(),
                entity.getStudentID(), entity.getTestID(),
                entity.getIndexQuestion());
    }

    @Override
    public List<Result> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Result selectById(Integer key) {
        return null;
    }

    public Result selectByIdSupport(int indexTest, String studentID, String testID, int indexQuestion) {
        List<Result> list = selectSql(SELECTBYID_SQL, indexTest,
                studentID, testID,
                indexQuestion);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public Result selectByTestStudent(String StudentID, String TestID) {
        List<Result> list = selectSqlSuport(SELECTBYTESTSTUDENT,
                StudentID, TestID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Result> selectSql(String Sql, Object... args) {
        List<Result> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                Result entity = new Result();
                entity.setIndexTest(rs.getInt(2));
                entity.setStudentID(rs.getString(3));
                entity.setTestID(rs.getString(4));
                entity.setIndexQuestion(rs.getInt(5));
                entity.setAnsSelected(rs.getString(6));
                entity.setAnsCorrect(rs.getString(7));
                entity.setDateTest(rs.getDate(8));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Result> selectSqlSuport(String Sql, Object... args) {
        List<Result> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                Result entity = new Result();
                entity.setIndexTest(rs.getInt(1));
                entity.setStudentID(rs.getString(2));
                entity.setTestID(rs.getString(3));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Result> selectByIndexTest(String studentID, String testID, int indexTest) {
        return selectSql(SELECTBYINDEXTEST, studentID, testID, indexTest);
    }

}
