package bitcamp.javatest.cms.control;
import java.util.Scanner;

import bitcamp.javatest.cms.domain.Member;

public class TeacherController {

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

    static Teacher []teachers = new Teacher[100];
    static int teacherIndex = 0;

    public static void serviceTeacherMenu() {
        while(true) {
            System.out.println("[list] or [add] or [quit]");
            System.out.println("선생 관리 > ");

            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            } else if(command.equals("add")) {
                inputTeacher();
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
            System.out.printf("%s, %s, %s, %d, %s, %s\n", t.getName()
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

            System.out.println("continue?(Y/n)");
            teachers[teacherIndex++] = t;

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }

}
