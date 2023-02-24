package com.studious.dao;

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

    final String INSERT_SQL = "INSERT INTO TAILIEUONTAP(TieuDe, URLTaiLieu, MaGV, MaBH) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE TAILIEUONTAP SET TieuDe = ?, URLTaiLieu = ?, MaBH = ? WHERE MaTL = ?";
    final String DELETE_SQL = "DELETE FROM TAILIEUONTAP WHERE MaTL = ?";
    final String SELECTALL_SQL = "SELECT * FROM TAILIEUONTAP";
    final String SELECTBYID_SQL = "SELECT * FROM TAILIEUONTAP WHERE MaTL = ?";
    final String SELECTBYLESSONID_SQL = "SELECT * FROM TAILIEUONTAP WHERE MaBH = ?";

    @Override
    public void insert(Document entity) {
        JdbcHelper.update(INSERT_SQL, entity.getDocTitle(),
                entity.getUrl(),
                entity.getTeacherID(),
                entity.getLessonID());
    }

    @Override
    public void update(Document entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getDocTitle(),
                entity.getUrl(),
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

    public List<Document> selectByLessonID(Integer key) {
        List<Document> list = selectSql(SELECTBYLESSONID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public List<Document> selectByDocumentTitle(String documentTitle){
        String sql = "SELECT * FROM TAILIEUONTAP WHERE TieuDe LIKE N'%"+documentTitle+"%'";
        List<Document> list = selectSql(sql);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Document> selectSql(String Sql, Object... args) {
        List<Document> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Document entity = new Document();
                entity.setDocID(rs.getInt(1));
                entity.setDocTitle(rs.getString(2));
                entity.setUrl(rs.getString(3));
                entity.setCreatDate(rs.getDate(4));
                entity.setTeacherID(rs.getString(5));
                entity.setLessonID(rs.getInt(6));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
