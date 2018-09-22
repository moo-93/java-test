import java.util.Scanner;

public class StudentController {

    static Scanner keyIn;
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
    
    static Student []students = new Student[100];
    static int studentsIndex = 0;
    
    static void serviceStudentMenu() {
        while(true) {
            System.out.println("[list] or [add] or [quit]");
            System.out.println("학생 관리 > ");

            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printStudents();
            } else if(command.equals("add")) {
                inputStudent();
            } else if(command.equals("quit")) {
                return;
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }

    static void printStudents() {
        int cnt = 0;
        for(Student s : students){
            if(cnt++ == studentsIndex) break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n", s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());   
        }
    }

    static void inputStudent() {
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
            students[studentsIndex++] = s;

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}
