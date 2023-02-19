package com.studious.DAO;

import com.studious.entity.Result;
import com.studious.entity.Test;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class ResutlDAO extends StudiousDAO<Result, Integer> {

    final String INSERT_SQL = "INSERT INTO LANTHI(MaLanThi, MaHS, MaBTHI, MaCau, DanAnChon, DanAnDung, NgayThi) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE LANTHI SET DanAnChon = ? WHERE (MaLanThi = ? AND MaHS = ? AND MaBTHI = ? AND MaCau = ?)";
    final String DELETE_SQL = "DELETE FROM LANTHI WHERE (MaLanThi = ? AND MaHS = ? AND MaBTHI = ? AND MaCau = ?)";
    final String SELECTALL_SQL = "SELECT * FROM LANTHI";
    final String SELECTBYID_SQL = "SELECT * FROM LANTHI WHERE (MaLanThi = ? AND MaHS = ? AND MaBTHI = ? AND MaCau = ?)";

    @Override
    public void insert(Result entity) {
        JdbcHelper.update(INSERT_SQL, entity.getIndexTest(),
                entity.getStudentID(), entity.getTestID(),
                entity.getIndexQuestion(), entity.getAnsSelected(),
                entity.getAnsCorrect(), entity.getDateTest());
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
        Result entity = selectById(key);
        return selectByIdSupport(entity);
    }

    public Result selectByIdSupport(Result entity) {
        List<Result> list = selectSql(SELECTBYID_SQL, entity.getIndexTest(),
                entity.getStudentID(), entity.getTestID(),
                entity.getIndexQuestion());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Result> selectSql(String Sql, Object... args) {
        List<Result> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Result entity = new Result();
                entity.setIndexTest(rs.getInt(1));
                entity.setStudentID(rs.getString(2));
                entity.setTestID(rs.getString(3));
                entity.setDateTest(rs.getDate(4));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
