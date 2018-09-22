package bitcamp.javatest.cms.control;
import java.util.Scanner;

import bitcamp.javatest.cms.domain.Member;

public class TeacherController {

    static Teacher []teachers = new Teacher[5];
    static int teacherIndex = 0;
    public static Scanner keyIn;
    
    static class Teacher extends Member{
        protected int pay;
        protected String subjects;

        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
    }


    public static void serviceTeacherMenu() {
        while(true) {
            System.out.println("[list] or [add] or [delete]"
                    + " or [detail] or [quit]");
            System.out.println("선생 관리 > ");

            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            } else if(command.equals("add")) {
                inputTeacher();
            } else if(command.equals("delete")) {
                deleteTeacher();  
            } else if(command.equals("detail")) {
                detailTeacher();
            } else if(command.equals("quit")) {
                return;
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }

    private static void printTeachers() {
        int cnt = 0;
        for(Teacher t : teachers){
            if(cnt++ == teacherIndex) break;
            System.out.printf("%d %s, %s, %s, %d, %s, %s\n", cnt - 1
                    ,t.getName()
                    ,t.getEmail()
                    ,t.getPassword()
                    ,t.getPay()
                    ,t.getSubjects()
                    ,t.getTel());   
        }
    }

    private static void inputTeacher() {
        while(true) {
            Teacher t = new Teacher();

            System.out.print("이름  > ");
            t.setName(keyIn.nextLine()); 

            System.out.print("이메일 > ");
            t.setEmail(keyIn.nextLine()); 

            System.out.print("암호 > ");
            t.setPassword(keyIn.nextLine()); 

            System.out.print("시급 > ");
            t.setPay(Integer.parseInt(keyIn.nextLine())); 

            System.out.print("강의과목 (예: C, C++, 자바) > ");
            t.setSubjects(keyIn.nextLine()); 

            System.out.print("전화번호 > ");
            t.setTel(keyIn.nextLine()); 
            
            if(teacherIndex == teachers.length) {
                increaseStorage();
            }

            System.out.println("continue?(Y/n)");
            teachers[teacherIndex++] = t;

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void increaseStorage() {

        Teacher []newList = new Teacher[teachers.length + 3];

        for(int i = 0; i < teachers.length; i++) {
            newList[i] = teachers[i];
        }

        teachers = newList;
    }

    private static void deleteTeacher() {

        System.out.print("삭제할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= teacherIndex) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        for(int i = no; i < teacherIndex - 1; i++) {
            teachers[i] = teachers[i+1];
        }
        teacherIndex--;
    }
    
    private static void detailTeacher() {
        
        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= teacherIndex) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        
        System.out.printf("이름 : %s ", teachers[no].getName());
        System.out.printf("이메일 : %s ", teachers[no].getEmail());
        System.out.printf("암호 : %s ", teachers[no].getPassword());
        System.out.printf("전화 : %s ", teachers[no].getTel());
        System.out.printf("시급 : %d ", teachers[no].getPay());
        System.out.printf("강의과목 : %s\n",teachers[no].getSubjects());
    }
}
