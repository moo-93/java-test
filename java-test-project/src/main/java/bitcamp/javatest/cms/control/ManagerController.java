package bitcamp.javatest.cms.control;
import java.util.Scanner;

import bitcamp.javatest.cms.domain.Member;

public class ManagerController {

    static Manager []managers = new Manager[5];
    static int managerIndex = 0;
    public static Scanner keyIn;
    
    static class Manager extends Member{
        protected String position;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }


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
        int cnt = 0;
        for(Manager m : managers){
            if(cnt++ == managerIndex) break;
            System.out.printf("%d %s, %s, %s, %s, %s\n", cnt - 1
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

            if(managerIndex == managers.length) {
                increaseStorage();
            }

            System.out.println("continue?(Y/n)");
            managers[managerIndex++] = m;

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void increaseStorage() {

        Manager []newList = new Manager[managers.length + 3];

        for(int i = 0; i < managers.length; i++) {
            newList[i] = managers[i];
        }

        managers = newList;
    }

    private static void deleteManager() {

        System.out.print("삭제할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= managerIndex) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        for(int i = no; i < managerIndex - 1; i++) {
            managers[i] = managers[i+1];
        }
        managerIndex--;
    }
    
    private static void detailManager() {
        
        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= managerIndex) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        
        System.out.printf("이름 : %s ", managers[no].getName());
        System.out.printf("이메일 : %s ", managers[no].getEmail());
        System.out.printf("암호 : %s ", managers[no].getPassword());
        System.out.printf("전화 : %s ", managers[no].getTel());
        System.out.printf("직책 : %s\n", managers[no].getPosition());
    }
}
