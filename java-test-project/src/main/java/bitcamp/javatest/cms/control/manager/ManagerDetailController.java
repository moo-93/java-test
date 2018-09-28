package bitcamp.javatest.cms.control.manager;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.domain.Manager;

@Component
public class ManagerDetailController {
    
    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {

        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= App.managers.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        Manager m = App.managers.get(no);
        System.out.printf("이름 : %s ", m.getName());
        System.out.printf("이메일 : %s ", m.getEmail());
        System.out.printf("암호 : %s ", m.getPassword());
        System.out.printf("전화 : %s ", m.getTel());
        System.out.printf("직책 : %s\n", m.getPosition());
    }
}
