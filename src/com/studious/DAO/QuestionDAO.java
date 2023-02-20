package com.studious.DAO;

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

    final String INSERT_SQL = "INSERT INTO CAUHOI(MaCH, De, DapAn1, DapAn2, DapAn3, DapAn4, DapAnDung, MaBH, MaGV) VALUES (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE CAUHOI SET De = ?, DapAn1 = ?, DapAn2 = ?, DapAn3 = ?, DapAn4 = ?, DapAnDung = ?, MaBH = ?, MaGV = ? WHERE MaCH = ?";
    final String DELETE_SQL = "DELETE FROM CAUHOI WHERE MaCH = ?";
    final String SELECTALL_SQL = "SELECT * FROM CAUHOI";
    final String SELECTBYID_SQL = "SELECT * FROM CAUHOI WHERE MaCH = ?";

    @Override
    public void insert(Question entity) {
        JdbcHelper.update(INSERT_SQL, entity.getQuestionID(), entity.getQuestion(),
                entity.getWrongAns1(), entity.getWrongAns2(),
                entity.getWrongAns3(), entity.getWrongAns4(),
                entity.getAns(), entity.getLessonID(),
                entity.getTeacherID()
        );
    }

    @Override
    public void update(Question entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getQuestion(),
                entity.getWrongAns1(), entity.getWrongAns2(),
                entity.getWrongAns3(), entity.getWrongAns4(),
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

    @Override
    public List<Question> selectSql(String Sql, Object... args) {
        List<Question> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.quyery(Sql, args);
            while (rs.next()) {
                Question entity = new Question();
                entity.setQuestionID(rs.getInt(1));
                entity.setQuestion(rs.getString(2));
                entity.setWrongAns1(rs.getString(3));
                entity.setWrongAns2(rs.getString(4));
                entity.setWrongAns3(rs.getString(5));
                entity.setWrongAns4(rs.getString(6));
                entity.setAns(rs.getString(7));
                entity.setLessonID(rs.getInt(8));
                entity.setTeacherID(rs.getString(9));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
