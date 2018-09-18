import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String[] name = new String[100];
        String[] email = new String[100];
        String[] password = new String[100];
        int index = 0;
        
        Scanner keyIn = new Scanner(System.in);

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
        for(int i = 0; i < index; i++) {
            System.out.printf("%s, %s, %s\n", name[i], email[i], password[i]);
        }
        keyIn.close();
    }
}
