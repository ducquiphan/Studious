package com.studious.DAO;

import com.studious.entity.Account;
import com.studious.ultils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class AccountDAO extends StudiousDAO<Account, String> {

    final String INSERT_SQL = "INSERT INTO TAIKHOAN(TenTaiKhoan, MatKhau, VatTro, TrangThai) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE TAIKHOAN SET MatKhau = ?, TrangThai = ? WHERE TenTaiKhoan = ?";
    final String DELETE_SQL = "DELETE FROM TAIKHOAN WHERE TenTaiKhoan = ?";
    final String SELECTALL_SQL = "SELECT * FROM TAIKHOAN";
    final String SELECTBYID_SQL = "SELECT * FROM TAIKHOAN WHERE TenTaiKhoan = ?";

    @Override
    public void insert(Account entity) {
        JdbcHelper.update(INSERT_SQL, entity.getUserID(), entity.getPassword(),
                entity.getRole(), entity.isStatus());
    }

    @Override
    public void update(Account entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getPassword(), entity.isStatus(), entity.getUserID());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Account> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Account selectById(String key) {
        List<Account> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Account> selectSql(String Sql, Object... args) {
        List<Account> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                Account entity = new Account();
                entity.setUserID(rs.getString(1));
                entity.setPassword(rs.getString(2));
                entity.setRole(rs.getInt(3));
                entity.setStatus(rs.getBoolean(4));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
