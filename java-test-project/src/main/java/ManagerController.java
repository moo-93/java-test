import java.util.Scanner;

public class ManagerController {

    static Scanner keyIn;
    static class Manager extends Member{
        protected String position;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    static Manager []managers = new Manager[100];
    static int managerIndex = 0;
    
    static void serviceManagerMenu() {
        while(true) {
            System.out.println("[list] or [add] or [quit]");
            System.out.println("매니저 관리 > ");

            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printManagers();
            } else if(command.equals("add")) {
                inputManager();
            } else if(command.equals("quit")) {
                return;
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }

    static void printManagers() {
        int cnt = 0;
        for(Manager m : managers){
            if(cnt++ == managerIndex) break;
            System.out.printf("%s, %s, %s, %s, %s\n", m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getPosition()
                    ,m.getTel());   
        }
    }

    static void inputManager() {
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
            managers[managerIndex++] = m;

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }

}
