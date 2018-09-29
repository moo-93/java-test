package bitcamp.javatest.cms.control.student;

import java.util.Scanner;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.dao.StudentDao;
import bitcamp.javatest.cms.domain.Student;

@Component
public class StudentAddController {
    StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while(true) {
            Student s = new Student();

            System.out.print("이름  > ");
            s.setName(keyIn.nextLine()); 

            System.out.print("이메일 > ");
            s.setEmail(keyIn.nextLine()); 

            System.out.print("암호 > ");
            s.setPassword(keyIn.nextLine()); 

            System.out.print("최종학력 > ");
            s.setSchool(keyIn.nextLine()); 

            System.out.print("재직여부(true/false) > ");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine())); 

            System.out.print("전화번호 > ");
            s.setTel(keyIn.nextLine()); 

            System.out.println("continue?(Y/n)");

            if(studentDao.insert(s) > 0) {
                System.out.println("저장 완료!");
            } else {
                System.out.println("입력하신 이메일의 학생이 존재합니다.");
            }

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}
