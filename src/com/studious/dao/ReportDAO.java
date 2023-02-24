package com.studious.DAO;

import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class ReportDAO {

    private List<Object[]> getListofArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(i + 1);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getQuestionOfSubject(String subject) {
        String sql = "{CALL  sp_ThongKeCauHoi_MonHoc(?)}";
        String[] cols = {"STT", "TenMH", "SoLuongCauHoi"};
        return getListofArray(sql, cols, subject);
    }

    public List<Object[]> getQuestionOfTeacher(String teacherName) {
        String sql = "{CALL  sp_ThongKeCauHoi_GiaoVien(?)}";
        String[] cols = {"STT", "TenGV", "SoLuongCauHoi"};
        return getListofArray(sql, cols, teacherName);
    }

    public List<Object[]> getMarkPerson(String studentID) {
        String sql = "{CALL  sp_ThongKeDiemCaNhanHS(?)}";
        String[] cols = {"STT", "MaBThi", "Diem", "LanThi", "ThoiGianHoanThanh"};
        return getListofArray(sql, cols, studentID);
    }

    public List<Object[]> getDocumentSubject(String subject) {
        String sql = "{CALL  sp_ThongKeTaiLieu_MonHoc(?)}";
        String[] cols = {"STT", "TenMonHoc", "SoLuongTaiLieu"};
        return getListofArray(sql, cols, subject);
    }

    public List<Object[]> getDocumentTeacher(String teacherName) {
        String sql = "{CALL  sp_ThongKeTaiLieu_GiaoVien(?)}";
        String[] cols = {"STT", "TenGiaoVien", "SoLuongTaiLieu"};
        return getListofArray(sql, cols, teacherName);
    }

    public List<Object[]> getMarkAllStudent(String testName) {
        String sql = "{CALL  sp_ThongKeDiemToanBoHS(?)}";
        String[] cols = {"MaHS", "TenHS", "Lop", "MaBThi", "TenBThi", "Diem", "NgayLam"};
        return getListofArray(sql, cols, testName);
    }

    public List<Object[]> getMarkAVG(String testName) {
        String sql = "{CALL  sp_ThongKeDiemTB(?)}";
        String[] cols = {"STT", "MaBThi", "DiemTBTong", "SoLanThi"};
        return getListofArray(sql, cols, testName);
    }
}
