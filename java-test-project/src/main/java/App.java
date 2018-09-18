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

    static Member []members = new Member[100];
    static int index = 0;

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {
        inputMember();
        printMember();
        keyIn.close();
    }

    static void printMember() {
        for(int i = 0; i < index; i++) {
            System.out.printf("%s, %s, %s\n", members[i].getName(), members[i].getEmail(), members[i].getPassword());
        }
    }

    static void inputMember() {
        while(true) {
            Member m = new Member();

            System.out.print("이름  > ");
            m.setName(keyIn.nextLine()); 

            System.out.print("이메일 > ");
            m.setEmail(keyIn.nextLine()); 

            System.out.print("암호 > ");
            m.setPassword(keyIn.nextLine()); 

            System.out.println("continue?(Y/n)");
            members[index++] = m;

            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}
