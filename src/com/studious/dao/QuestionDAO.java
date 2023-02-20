package com.studious.dao;

import com.studious.entity.Lesson;
import com.studious.entity.Question;
import com.studious.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public class QuestionDAO extends StudiousDAO<Question, Integer> {

    final String INSERT_SQL = "INSERT INTO CAUHOI(De, DapAn1, DapAn2, DapAn3, DapAn4, DapAnDung, MaBH, MaGV) VALUES (?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE CAUHOI SET De = ?, DapAn1 = ?, DapAn2 = ?, DapAn3 = ?, DapAn4 = ?, DapAnDung = ?, MaBH = ?, MaGV = ? WHERE MaCH = ?";
    final String DELETE_SQL = "DELETE FROM CAUHOI WHERE MaCH = ?";
    final String SELECTALL_SQL = "SELECT * FROM CAUHOI";
    final String SELECTBYID_SQL = "SELECT * FROM CAUHOI WHERE MaCH = ?";
    final String SELECTBYLESSONID_SQL = "SELECT * FROM CAUHOI WHERE MaBH = ?";

    @Override
    public void insert(Question entity) {
        JdbcHelper.update(INSERT_SQL, entity.getQuestion(),
                entity.getAns1(), entity.getAns2(),
                entity.getAns3(), entity.getAns4(),
                entity.getAns(), entity.getLessonID(),
                entity.getTeacherID()
        );
    }

    @Override
    public void update(Question entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getQuestion(),
                entity.getAns1(), entity.getAns2(),
                entity.getAns3(), entity.getAns4(),
                entity.getAns(), entity.getLessonID(),
                entity.getTeacherID(), entity.getQuestionID());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Question> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Question selectById(Integer key) {
        List<Question> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<Question> selectByLessonID(Integer key){
        List<Question> list = selectSql(SELECTBYLESSONID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public List<Question> selectByQuestion(String question){
        String sql = "SELECT * FROM CAUHOI WHERE De LIKE N'%"+question+"%'";
        List<Question> list = selectSql(sql);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    @Override
    public List<Question> selectSql(String Sql, Object... args) {
        List<Question> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Question entity = new Question();
                entity.setQuestionID(rs.getInt(1));
                entity.setQuestion(rs.getString(2));
                entity.setAns1(rs.getString(3));
                entity.setAns2(rs.getString(4));
                entity.setAns3(rs.getString(5));
                entity.setAns4(rs.getString(6));
                entity.setAns(rs.getString(7));
                entity.setLessonID(rs.getInt(8));
                entity.setTeacherID(rs.getString(9));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
