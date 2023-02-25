package com.studious.dao;

import com.studious.dao.StudiousDAO;
import com.studious.entity.Teacher;
import java.util.ArrayList;
import java.util.List;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;

/**
 *
 * @author NGUYEN VAN SI
 */
public class TeacherDAO extends StudiousDAO<Teacher, String> {

    final String INSERT_SQL = "INSERT INTO GIAOVIEN(MaGV, HoVaTen, GioiTinh, NgaySinh, MaDinhDanh, ChuyenMon, Email, PathIMG, MaTK) VALUES (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE GIAOVIEN SET HoVaTen = ?, GioiTinh = ?, NgaySinh = ?, MaDinhDanh =?, ChuyenMon = ?, Email = ?, PathIMG = ?, MaTK = ? WHERE MaGV = ?";
    final String DELETE_SQL = "DELETE FROM GIAOVIEN WHERE MaGV = ?";
    final String SELECTALL_SQL = "SELECT * FROM GIAOVIEN";
    final String SELECTBYID_SQL = "SELECT * FROM GIAOVIEN WHERE MaGV = ?";
    final String SELECTBYMDD_SQL = "SELECT * FROM GIAOVIEN WHERE MaDinhDanh =?";

    @Override
    public void insert(Teacher entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTeacherID(), entity.getFullname(),
                entity.isGender(), entity.getBirthDate(), entity.getIdentifier(), 
                entity.getMajor(), entity.getEmail(), entity.getAvtURL(),
                entity.getAccountID());
    }

    @Override
    public void update(Teacher entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getFullname(), entity.isGender(),
                entity.getBirthDate(),entity.getIdentifier(), entity.getMajor(),
                entity.getEmail(),entity.getAvtURL(), entity.getAccountID(),
                entity.getTeacherID());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Teacher> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Teacher selectById(String key) {
        List<Teacher> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public Teacher selectByMdd(String key) {
        List<Teacher> list = selectSql(SELECTBYMDD_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    @Override
    public List<Teacher> selectSql(String Sql, Object... args) {
        List<Teacher> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Teacher entity = new Teacher();
                entity.setTeacherID(rs.getString(1));
                entity.setFullname(rs.getString(2));
                entity.setGender(rs.getBoolean(3));
                entity.setBirthDate(rs.getDate(4));
                entity.setIdentifier(rs.getString(5));
                entity.setMajor(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setAvtURL(rs.getString(8));
                entity.setTeacherID(rs.getString(9));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<Teacher> selectByName(String name){
        String sql = "SELECT * FROM GIAOVIEN WHERE HoVaTen LIKE N'%" + name + "%'";
        List<Teacher> list = selectSql(sql);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
