package bitcamp.javatest.cms.control.teacher;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.domain.Teacher;

@Component
public class TeacherDetailController {

    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {

        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= App.teachers.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        Teacher t = App.teachers.get(no);
        System.out.printf("이름 : %s ", t.getName());
        System.out.printf("이메일 : %s ", t.getEmail());
        System.out.printf("암호 : %s ", t.getPassword());
        System.out.printf("전화 : %s ", t.getTel());
        System.out.printf("시급 : %d ", t.getPay());
        System.out.printf("강의과목 : %s\n",t.getSubjects());
    }
}
