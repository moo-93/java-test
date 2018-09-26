import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import bitcamp.javatest.cms.control.Controller;
import bitcamp.javatest.cms.control.ManagerController;
import bitcamp.javatest.cms.control.StudentController;
import bitcamp.javatest.cms.control.TeacherController;
import bitcamp.javatest.cms.domain.Manager;
import bitcamp.javatest.cms.domain.Student;
import bitcamp.javatest.cms.domain.Teacher;

public class App {

    static Scanner keyIn = new Scanner(System.in);


    public static void main(String[] args) {

        HashMap<String, Controller> requestHandlerMapping = new HashMap<>();

        requestHandlerMapping.put("1", new StudentController(new LinkedList<Student>()));
        requestHandlerMapping.put("2", new TeacherController(new ArrayList<Teacher>()));
        requestHandlerMapping.put("3", new ManagerController(new ArrayList<Manager>()));

        while(true) {
            String menu = promptMenu();

            if (menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }

            Controller controller = requestHandlerMapping.get(menu);

            if(controller != null) {
                controller.service(keyIn);
            } else 
                System.out.println("해당 메뉴가 존재하지 않습니다."); 
        }
        keyIn.close();
    }

    private static String promptMenu() {
        while(true) {
            System.out.println("[메뉴]");
            System.out.println("1.학생관리 \t 2.강사관리 \t 3.매니저관리 \t 0.종료");

            String menu = keyIn.nextLine();
            switch(menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }

}
