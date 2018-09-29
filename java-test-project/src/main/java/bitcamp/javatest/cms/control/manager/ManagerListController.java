package bitcamp.javatest.cms.control.manager;

import java.util.List;
import java.util.Scanner;

import bitcamp.javatest.cms.App;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.domain.Manager;

@Component
public class ManagerListController {
    
    @RequestMapping("manager/list")
    public void printTeachers(Scanner keyIn) {
        List<Manager> list = App.managerDao.findAll();
        for(Manager m : list) {
            System.out.printf("%s, %s, %s, %s, %s\n"
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getPosition()
                    ,m.getTel());   
        }
    }
}
