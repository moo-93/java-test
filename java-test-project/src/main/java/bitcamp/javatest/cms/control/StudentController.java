package bitcamp.javatest.cms.control;
import java.util.Scanner;

import bitcamp.javatest.cms.domain.Member;

public class StudentController {

    static Student []students = new Student[5];
    static int studentIndex = 0;
    public static Scanner keyIn;
    
    static class Student extends Member{
        protected String school;
        protected boolean working;

        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
    }
    
    
    public static void serviceStudentMenu() {
        while(true) {
            System.out.println("[list] or [add] or [delete]"
                    + " or [detail] or [quit]");
            System.out.println("학생 관리 > ");

            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printStudents();
            } else if(command.equals("add")) {
                inputStudent();
            } else if(command.equals("delete")) {
                deleteStudent();  
            } else if(command.equals("detail")) {
                detailStudent();
            } else if(command.equals("quit")) {
                return;
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }

    private static void printStudents() {
        int cnt = 0;
        for(Student s : students){
            if(cnt++ == studentIndex) break;
            System.out.printf("%d %s, %s, %s, %s, %b, %s\n", cnt - 1
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());   
        }
    }

    private static void inputStudent() {
        while(true) {
            Student s = new Student();

            System.out.print("이름  > ");
            s.setName(keyIn.nextLine()); 

            System.out.print("이메일 > ");
            s.setEmail(keyIn.nextLine()); 

            System.out.print("암호 > ");
            s.setPassword(keyIn.nextLine()); 

            System.out.print("최종학력 > ");
            s.setSchool(keyIn.nextLine()); 

            System.out.print("재직여부(true/false) > ");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine())); 

            System.out.print("전화번호 > ");
            s.setTel(keyIn.nextLine()); 
            
            if(studentIndex == students.length) {
                increaseStorage();
            }

            System.out.println("continue?(Y/n)");
            students[studentIndex++] = s;

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    private static void increaseStorage() {

        Student []newList = new Student[students.length + 3];

        for(int i = 0; i < students.length; i++) {
            newList[i] = students[i];
        }

        students = newList;
    }

    private static void deleteStudent() {

        System.out.print("삭제할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= studentIndex) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        for(int i = no; i < studentIndex - 1; i++) {
            students[i] = students[i+1];
        }
        studentIndex--;
    }
    
    private static void detailStudent() {
        System.out.println(studentIndex);
        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= studentIndex) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        
        System.out.printf("이름 : %s ", students[no].getName());
        System.out.printf("이메일 : %s ", students[no].getEmail());
        System.out.printf("암호 : %s ", students[no].getPassword());
        System.out.printf("전화 : %s ", students[no].getTel());
        System.out.printf("최종학력 : %s ", students[no].getSchool());
        System.out.printf("재직여부 : %b\n",students[no].isWorking());
    }
}
