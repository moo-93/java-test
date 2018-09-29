package bitcamp.javatest.cms.control.manager;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;

@Component
public class ManagerDeleteController {
    
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {

        System.out.print("삭제할 이메일 > ");
        String email = keyIn.nextLine();

        if(App.managerDao.delete(email) > 0) {
            System.out.println("삭제 완료!");
        } else {
            System.out.println("해당 이메일의 매니저가 존재하지 않습니다.");
        }
    }
}
