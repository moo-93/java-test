import java.util.Scanner;

public class App {

    static class Member{
        protected String name;
        protected String email;
        protected String password;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
    
    static class Student extends Member{
        protected String school;
        protected boolean working;
        protected String tel;
        
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
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
    }

    static Student []students = new Student[100];
    static int index = 0;

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {
        
        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                serviceStudentMenu();
            } else if (menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
        }
        keyIn.close();
    }

    private static void serviceStudentMenu() {
        while(true) {
            System.out.println("[list] or [add] or [quit]");
            System.out.println("학생 관리 > ");

            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printMembers();
            } else if(command.equals("add")) {
                inputMember();
            } else if(command.equals("quit")) {
                return;
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }
    private static String promptMenu() {
        while(true) {
            System.out.println("[메뉴]");
            System.out.println("1.학생관리 \t 2.매니저관리 \t 3.선생관리 \t 0.종료");

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
    static void printMembers() {
        int cnt = 0;
        for(Student s : students){
            if(cnt++ == index) break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n", s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());   
        }
    }

    static void inputMember() {
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
            students[index++] = s;

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}
