package com.studious.DAO;

import com.studious.entity.Lesson;
import com.studious.entity.QnA;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class QnADAO extends StudiousDAO<QnA, Integer> {

    final String INSERT_SQL = "INSERT INTO HOIDAP(MaHD, NoiDung, NgayTao, NguoiTao, MaCH) VALUES (?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE HOIDAP SET NoiDung = ? WHERE MaHD = ?";
    final String DELETE_SQL = "DELETE FROM HOIDAP WHERE MaHD = ?";
    final String SELECTALL_SQL = "SELECT * FROM HOIDAP";
    final String SELECTBYID_SQL = "SELECT * FROM HOIDAP WHERE MaHD = ?";

    @Override
    public void insert(QnA entity) {
        JdbcHelper.update(INSERT_SQL, entity.getQnaID(), entity.getContent(),
                entity.getCreateDate(), entity.getUserID(),
                entity.getQuestionID());
    }

    @Override
    public void update(QnA entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getContent(), entity.getQnaID());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<QnA> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public QnA selectById(Integer key) {
        List<QnA> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QnA> selectSql(String Sql, Object... args) {
        List<QnA> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                QnA entity = new QnA();
                entity.setQnaID(rs.getInt(1));
                entity.setContent(rs.getString(2));
                entity.setCreateDate(rs.getDate(3));
                entity.setUserID(rs.getString(4));
                entity.setQuestionID(rs.getInt(5));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
