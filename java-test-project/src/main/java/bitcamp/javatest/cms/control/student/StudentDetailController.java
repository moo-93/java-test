package bitcamp.javatest.cms.control.student;

import java.util.Scanner;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.dao.StudentDao;
import bitcamp.javatest.cms.domain.Student;

@Component
public class StudentDetailController {
    
    StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/detail")
    public void detail(Scanner keyIn) {

        System.out.print("조회할 이메일 > ");
        String email = keyIn.nextLine();
        
        Student s = studentDao.findByEmail(email);
        
        if(s == null) {
            System.out.println("해당 이메일의 학생 정보가 존재하지 않습니다.");
            return ;
        }
        
        System.out.printf("이름 : %s ", s.getName());
        System.out.printf("이메일 : %s ", s.getEmail());
        System.out.printf("암호 : %s ", s.getPassword());
        System.out.printf("전화 : %s ", s.getTel());
        System.out.printf("최종학력 : %s ", s.getSchool());
        System.out.printf("재직여부 : %b\n",s.isWorking());
    }
}
