package bitcamp.javatest.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.dao.TeacherDao;
import bitcamp.javatest.cms.domain.Teacher;

@Component
public class TeacherListController {
    TeacherDao teacherDao;

    @Autowired
    public void setTeahcerDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    @RequestMapping("teacher/list")
    public void printTeachers(Scanner keyIn) {
        List<Teacher> list = teacherDao.findAll();
        for(Teacher t : list){
            System.out.printf("%s, %s, %s, %d, %s, %s\n"
                    ,t.getName()
                    ,t.getEmail()
                    ,t.getPassword()
                    ,t.getPay()
                    ,t.getSubjects()
                    ,t.getTel());   
        }
    }
}
