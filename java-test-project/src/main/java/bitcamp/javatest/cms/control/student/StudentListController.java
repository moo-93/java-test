package bitcamp.javatest.cms.control.student;

import java.util.List;
import java.util.Scanner;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.dao.StudentDao;
import bitcamp.javatest.cms.domain.Student;

@Component
public class StudentListController {
    
    StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
        List<Student> list = studentDao.findAll();
        for(Student s : list) {
            System.out.printf("%s, %s, %s, %s, %b, %s\n"
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());   
        }
    }
}
