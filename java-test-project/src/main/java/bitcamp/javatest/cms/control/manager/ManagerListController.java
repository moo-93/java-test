package bitcamp.javatest.cms.control.manager;

import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.domain.Manager;

@Component
public class ManagerListController {
    
    @RequestMapping("manager/list")
    public void printTeachers(Scanner keyIn) {
        for(int i = 0; i < App.managers.size(); i++){
            Manager m = App.managers.get(i);
            System.out.printf("%d %s, %s, %s, %s, %s\n", i
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getPosition()
                    ,m.getTel());   
        }
    }
}
