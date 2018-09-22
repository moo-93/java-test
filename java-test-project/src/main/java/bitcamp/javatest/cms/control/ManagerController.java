package bitcamp.javatest.cms.control;
import java.util.Scanner;

import bitcamp.javatest.cms.control.dao.ManagerList;
import bitcamp.javatest.cms.domain.Manager;

public class ManagerController {

    public static Scanner keyIn;

    public static void serviceManagerMenu() {
        while(true) {
            System.out.println("[list] or [add] "
                    + "or [delete] or [detail] or [quit]");
            System.out.println("매니저 관리 > ");

            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printManagers();
            } else if(command.equals("add")) {
                inputManager();
            } else if(command.equals("delete")) {
                deleteManager();  
            } else if(command.equals("detail")) {
                detailManager();
            } else if(command.equals("quit")) {
                return;
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }

    private static void printManagers() {
        for(int i = 0; i<ManagerList.size(); i++){
            Manager m = ManagerList.get(i);
            System.out.printf("%d %s, %s, %s, %s, %s\n", i
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getPosition()
                    ,m.getTel());   
        }
    }

    private static void inputManager() {
        while(true) {
            Manager m = new Manager();

            System.out.print("이름  > ");
            m.setName(keyIn.nextLine()); 

            System.out.print("이메일 > ");
            m.setEmail(keyIn.nextLine()); 

            System.out.print("암호 > ");
            m.setPassword(keyIn.nextLine()); 

            System.out.print("포지션 > ");
            m.setPosition(keyIn.nextLine());

            System.out.print("전화번호 > ");
            m.setTel(keyIn.nextLine()); 

            System.out.println("continue?(Y/n)");

            ManagerList.add(m);
            
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void deleteManager() {

        System.out.print("삭제할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= ManagerList.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        ManagerList.remove(no);
    }
    
    private static void detailManager() {
        
        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= ManagerList.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        Manager m = ManagerList.get(no);
        System.out.printf("이름 : %s ", m.getName());
        System.out.printf("이메일 : %s ", m.getEmail());
        System.out.printf("암호 : %s ", m.getPassword());
        System.out.printf("전화 : %s ", m.getTel());
        System.out.printf("직책 : %s\n", m.getPosition());
    }
}
