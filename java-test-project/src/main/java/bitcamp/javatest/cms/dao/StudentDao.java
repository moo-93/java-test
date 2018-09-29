package bitcamp.javatest.cms.dao;

import java.util.List;

import bitcamp.javatest.cms.domain.Student;

public interface StudentDao {

    public int insert(Student student);
    public List<Student> findAll();
    public Student findByEmail(String email);
    public int delete(String email);
}
