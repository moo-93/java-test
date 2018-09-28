package bitcamp.javatest.cms.control.teacher;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {
    
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {

        System.out.print("삭제할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= App.teachers.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        App.teachers.remove(no);
    }
}
