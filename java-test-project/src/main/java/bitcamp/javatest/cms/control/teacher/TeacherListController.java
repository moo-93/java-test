package bitcamp.javatest.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    @RequestMapping("teacher/list")
    public void printTeachers(Scanner keyIn) {
        List<Teacher> list = App.teacherDao.findAll();
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
