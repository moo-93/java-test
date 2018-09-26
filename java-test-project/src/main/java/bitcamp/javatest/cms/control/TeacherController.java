package bitcamp.javatest.cms.control;
import java.util.Scanner;

import bitcamp.javatest.cms.domain.Teacher;
import bitcamp.javatest.cms.util.List;

public class TeacherController {

    private List<Teacher> teachers;
    private Scanner keyIn;

    public TeacherController(Scanner keyIn, List<Teacher> teachers) {
        this.keyIn = keyIn;
        this.teachers = teachers;
    }
    
    public void serviceTeacherMenu() {
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

    private void printTeachers() {
        for(int i = 0; i < teachers.size(); i++){
            Teacher t = teachers.get(i);
            System.out.printf("%d %s, %s, %s, %d, %s, %s\n", i
                    ,t.getName()
                    ,t.getEmail()
                    ,t.getPassword()
                    ,t.getPay()
                    ,t.getSubjects()
                    ,t.getTel());   
        }
    }

    private void inputTeacher() {
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
            
            teachers.add(t);
            
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }

    private void deleteTeacher() {

        System.out.print("삭제할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= teachers.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        teachers.remove(no);
    }
    
    private void detailTeacher() {
        
        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= teachers.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        Teacher t = teachers.get(no);
        System.out.printf("이름 : %s ", t.getName());
        System.out.printf("이메일 : %s ", t.getEmail());
        System.out.printf("암호 : %s ", t.getPassword());
        System.out.printf("전화 : %s ", t.getTel());
        System.out.printf("시급 : %d ", t.getPay());
        System.out.printf("강의과목 : %s\n",t.getSubjects());
    }
}
