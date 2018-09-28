package bitcamp.javatest.cms.control.student;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.domain.Student;

@Component
public class StudentDetailController {
    
    @RequestMapping("student/detail")
    public void detail(Scanner keyIn) {

        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= App.students.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        Student s = App.students.get(no);
        
        System.out.printf("이름 : %s ", s.getName());
        System.out.printf("이메일 : %s ", s.getEmail());
        System.out.printf("암호 : %s ", s.getPassword());
        System.out.printf("전화 : %s ", s.getTel());
        System.out.printf("최종학력 : %s ", s.getSchool());
        System.out.printf("재직여부 : %b\n",s.isWorking());
    }
}
