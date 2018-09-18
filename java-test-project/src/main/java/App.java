import java.util.Scanner;

public class App {
    public static String[] name = new String[100];
    public static String[] email = new String[100];
    public static String[] password = new String[100];
    public static int index = 0;
    
    public static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        inputMember();
        printMember();
        keyIn.close();
    }

    public static void printMember() {
        for(int i = 0; i < index; i++) {
            System.out.printf("%s, %s, %s\n", name[i], email[i], password[i]);
        }
    }

    public static void inputMember() {
        while(true) {
            System.out.print("이름  > ");
            name[index] = keyIn.nextLine();

            System.out.print("이메일 > ");
            email[index] = keyIn.nextLine();

            System.out.print("암호 > ");
            password[index] = keyIn.nextLine();

            System.out.println("continue?(Y/n)");

            index++;
            
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}
