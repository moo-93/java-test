package bitcamp.javatest.cms.control.manager;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;

@Component
public class ManagerDeleteController {
    
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {

        System.out.print("삭제할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= App.managers.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        App.managers.remove(no);
    }
}
