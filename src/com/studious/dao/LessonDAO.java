package com.studious.DAO;

import com.studious.entity.Lesson;
import java.util.ArrayList;
import java.util.List;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;

/**
 *
 * @author NGUYEN VAN SI
 */
public class LessonDAO extends StudiousDAO<Lesson, Integer> {

    final String INSERT_SQL = "INSERT INTO BAIHOC(MaBH, TenBH, MonHoc, Khoi, NgayTao, MaGV) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE BAIHOC SET TenBH = ?, MonHoc = ?, Khoi = ?, NgayTao = ?, MaGV = ? WHERE MaBH = ?";
    final String DELETE_SQL = "DELETE FROM BAIHOC WHERE MaBH = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAIHOC";
    final String SELECTBYID_SQL = "SELECT * FROM BAIHOC WHERE MaBH = ?";

    @Override
    public void insert(Lesson entity) {
        JdbcHelper.update(INSERT_SQL, entity.getLessonID(),
                entity.getLessonName(), entity.getSubject(),
                entity.getGrade(), entity.getDateCreated(),
                entity.getTeacherID());
    }

    @Override
    public void update(Lesson entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getLessonName(),
                entity.getSubject(), entity.getGrade(),
                entity.getDateCreated(), entity.getTeacherID(),
                entity.getLessonID());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Lesson> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Lesson selectById(Integer key) {
        List<Lesson> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Lesson> selectSql(String Sql, Object... args) {
        List<Lesson> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                Lesson entity = new Lesson();
                entity.setLessonID(rs.getInt(1));
                entity.setLessonName(rs.getString(2));
                entity.setSubject(rs.getString(3));
                entity.setGrade(rs.getInt(4));
                entity.setDateCreated(rs.getDate(5));
                entity.setTeacherID(rs.getString(6));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
