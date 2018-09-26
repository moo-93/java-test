import java.util.Scanner;

import bitcamp.javatest.cms.control.ManagerController;
import bitcamp.javatest.cms.control.StudentController;
import bitcamp.javatest.cms.control.TeacherController;
import bitcamp.javatest.cms.domain.Manager;
import bitcamp.javatest.cms.domain.Student;
import bitcamp.javatest.cms.domain.Teacher;
import bitcamp.javatest.cms.util.ArrayList;
import bitcamp.javatest.cms.util.LinkedList;

public class App {

    static Scanner keyIn = new Scanner(System.in);
    static int index = 0;


    public static void main(String[] args) {
        
        StudentController sc = new StudentController(
                keyIn, new LinkedList<Student>());
        TeacherController tc = new TeacherController(
                keyIn, new ArrayList<Teacher>());
        ManagerController mc = new ManagerController(
                keyIn, new ArrayList<Manager>());
        
        while(true) {
            String menu = promptMenu();

            if(menu.equals("1")) {
                sc.serviceStudentMenu();
            } else if(menu.equals("2")){
                tc.serviceTeacherMenu();
            } else if(menu.equals("3")) {
                mc.serviceManagerMenu();
            } else if (menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
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
