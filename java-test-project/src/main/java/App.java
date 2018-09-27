import java.util.Scanner;

import bitcamp.javatest.cms.context.ApplicationContext;
import bitcamp.javatest.cms.control.Controller;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        ApplicationContext iocContainer =
                new ApplicationContext("bitcamp.javatest.cms.control");
        while(true) {
            String menu = promptMenu();

            if (menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }

            Controller controller = (Controller)iocContainer.get(menu);

            if(controller != null) {
                controller.service(keyIn);
            } else 
                System.out.println("해당 메뉴가 존재하지 않습니다."); 
        }
        keyIn.close();
    }

    private static String promptMenu() {
        System.out.println("[메뉴]");
        System.out.println("1.학생관리 \t 2.강사관리 \t 3.매니저관리 \t 0.종료");
        while(true) {
            System.out.println("inputMenu > ");
            String menu = keyIn.nextLine();
            
            return menu;
        }
    }

}
