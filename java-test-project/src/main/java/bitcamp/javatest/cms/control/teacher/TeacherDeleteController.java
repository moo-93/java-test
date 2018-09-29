package bitcamp.javatest.cms.control.teacher;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {
    
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {

        System.out.print("삭제할 이메일 > ");
        String email = keyIn.nextLine();

        if(App.teacherDao.delete(email) > 0) {
            System.out.println("삭제 완료!");
        } else {
            System.out.println("입력하신 이메일의 선생이 존재하지 않습니다.");
        }
    }
}
