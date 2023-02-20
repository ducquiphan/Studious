package com.studious.DAO;

import com.studious.entity.Document;
import com.studious.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author NGUYEN VAN SI
 */
public class DocumentDAO extends StudiousDAO<Document, Integer> {

    final String INSERT_SQL = "INSERT INTO TAILIEUONTAP(MaTL, TieuDe, MonHoc, NoiDungTL, NgayTao, MaGV, MaBH) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE TAILIEUONTAP SET TieuDe = ?, MonHoc = ?, NoiDungTL = ?, NgayTao = ?, MaGV = ?, MaBH = ? WHERE MaTL = ?";
    final String DELETE_SQL = "DELETE FROM TAILIEUONTAP WHERE MaTL = ?";
    final String SELECTALL_SQL = "SELECT * FROM TAILIEUONTAP";
    final String SELECTBYID_SQL = "SELECT * FROM TAILIEUONTAP WHERE MaTL = ?";

    @Override
    public void insert(Document entity) {
        JdbcHelper.update(INSERT_SQL, entity.getDocID(), entity.getDocTitle(),
                entity.getLesson(), entity.getContent(),
                entity.getCreatDate(), entity.getTeacherID(),
                entity.getLessonID());
    }

    @Override
    public void update(Document entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getDocTitle(),
                entity.getLesson(), entity.getContent(),
                entity.getCreatDate(), entity.getTeacherID(),
                entity.getLessonID(), entity.getDocID());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Document> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Document selectById(Integer key) {
        List<Document> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Document> selectSql(String Sql, Object... args) {
        List<Document> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                Document entity = new Document();
                entity.setDocID(rs.getInt(1));
                entity.setDocTitle(rs.getString(2));
                entity.setLesson(rs.getString(3));
                entity.setContent(rs.getString(4));
                entity.setCreatDate(rs.getDate(5));
                entity.setTeacherID(rs.getString(6));
                entity.setLessonID(rs.getInt(7));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
