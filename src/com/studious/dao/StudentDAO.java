package com.studious.dao;

import com.studious.entity.Student;
import java.util.ArrayList;
import java.util.List;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;

/**
 *
 * @author NGUYEN VAN SI
 */
public class StudentDAO extends StudiousDAO<Student, String> {

    final String INSERT_SQL = "INSERT INTO HOCSINH(MaHS, HoVaTen, GioiTinh, NgaySinh, Email, SoDT, Khoi, PathIMG, MaTK) VALUES (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE HOCSINH SET HoVaTen = ?, GioiTinh = ?, NgaySinh = ?, Email = ?, SoDT = ?, Khoi = ?, PathIMG = ?, MaTK = ? WHERE MaHS = ?";
    final String DELETE_SQL = "DELETE FROM HOCSINH WHERE MaHS = ?";
    final String SELECTALL_SQL = "SELECT * FROM HOCSINH";
    final String SELECTBYID_SQL = "SELECT * FROM HOCSINH WHERE MaHS = ?";

    @Override
    public void insert(Student entity) {
        JdbcHelper.update(INSERT_SQL, entity.getStudentID(), entity.getFullname(),
                entity.isGender(), entity.getBirthDate(), entity.getEmail(),
                entity.getPhone(), entity.getGrade(), entity.getAvtURL(),
                entity.getAccountID());
    }

    @Override
    public void update(Student entity) {
    JdbcHelper.update(UPDATE_SQL, entity.getFullname(), entity.isGender(),
            entity.getBirthDate(), entity.getEmail(), entity.getPhone(),
            entity.getGrade(), entity.getAvtURL(), entity.getAccountID(),
            entity.getStudentID());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Student> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Student selectById(String key) {
        List<Student> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Student> selectSql(String Sql, Object... args) {
        List<Student> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Student entity = new Student();
                entity.setStudentID(rs.getString(1));
                entity.setFullname(rs.getString(2));
                entity.setGender(rs.getBoolean(3));
                entity.setBirthDate(rs.getDate(4));
                entity.setEmail(rs.getString(5));
                entity.setPhone(rs.getString(6));
                entity.setGrade(rs.getInt(7));
                entity.setAvtURL(rs.getString(8));
                entity.setAccountID(rs.getString(9));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
