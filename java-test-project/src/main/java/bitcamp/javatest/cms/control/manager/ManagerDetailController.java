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

        System.out.print("조회할 이메일 > ");
        String email = keyIn.nextLine();

        Manager m = App.managerDao.findByEmail(email);
        
        if(m == null) {
            System.out.println("해당 이메일의 매니저 정보가 존재하지 않습니다.");
            return ;
        }
        
        System.out.printf("이름 : %s ", m.getName());
        System.out.printf("이메일 : %s ", m.getEmail());
        System.out.printf("암호 : %s ", m.getPassword());
        System.out.printf("전화 : %s ", m.getTel());
        System.out.printf("직책 : %s\n", m.getPosition());
    }
}
