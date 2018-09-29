package bitcamp.javatest.cms.dao;

import java.util.List;

import bitcamp.javatest.cms.domain.Teacher;

public interface TeacherDao {

   public int insert(Teacher teacher);
    public List<Teacher> findAll();
    public Teacher findByEmail(String email);
    public int delete(String email);
}
