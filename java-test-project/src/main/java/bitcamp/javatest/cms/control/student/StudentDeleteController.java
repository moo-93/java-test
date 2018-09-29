package bitcamp.javatest.cms.control.student;

import java.util.Scanner;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.dao.StudentDao;

@Component
public class StudentDeleteController {
    
    StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {

        System.out.print("삭제할 학생의 이메일 > ");
        String email = keyIn.nextLine();

        if(studentDao.delete(email) > 0) {
            System.out.println("삭제 완료!");
        } else {
            System.out.println("해당 이메일의 학생이 존재하지 않습니다.");
        }
    }
}
