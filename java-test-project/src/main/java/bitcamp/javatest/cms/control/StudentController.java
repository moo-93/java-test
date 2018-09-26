package bitcamp.javatest.cms.control;
import java.util.Scanner;

import bitcamp.javatest.cms.domain.Student;
import bitcamp.javatest.cms.util.List;

public class StudentController {

    private List<Student> students;
    private Scanner keyIn;
    
    public StudentController(Scanner keyIn, List<Student> students) {
        this.keyIn = keyIn;
        this.students = students;
    }
    
    public void serviceStudentMenu() {
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

    private void printStudents() {
        for(int i = 0; i< students.size(); i++){
            Student s = students.get(i);
            System.out.printf("%d %s, %s, %s, %s, %b, %s\n",i
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());   
        }
    }

    private void inputStudent() {
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
            
            System.out.println("continue?(Y/n)");
            
            students.add(s);

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    

    private void deleteStudent() {

        System.out.print("삭제할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= students.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        
        students.remove(no);
    }
    
    private void detailStudent() {

        System.out.print("조회할 번호 > ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= students.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }
        Student s = students.get(no);
        
        System.out.printf("이름 : %s ", s.getName());
        System.out.printf("이메일 : %s ", s.getEmail());
        System.out.printf("암호 : %s ", s.getPassword());
        System.out.printf("전화 : %s ", s.getTel());
        System.out.printf("최종학력 : %s ", s.getSchool());
        System.out.printf("재직여부 : %b\n",s.isWorking());
    }
}
