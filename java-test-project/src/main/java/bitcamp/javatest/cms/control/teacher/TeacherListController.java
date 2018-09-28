package bitcamp.javatest.cms.control.teacher;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    @RequestMapping("teacher/list")
    public void printTeachers(Scanner keyIn) {
        for(int i = 0; i < App.teachers.size(); i++){
            Teacher t = App.teachers.get(i);
            System.out.printf("%d %s, %s, %s, %d, %s, %s\n", i
                    ,t.getName()
                    ,t.getEmail()
                    ,t.getPassword()
                    ,t.getPay()
                    ,t.getSubjects()
                    ,t.getTel());   
        }
    }
}
