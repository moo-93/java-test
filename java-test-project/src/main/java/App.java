import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.context.ApplicationContext;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        ApplicationContext iocContainer =
                new ApplicationContext("bitcamp.javatest.cms.control");
        while(true) {
            String menu = promptMenu();

            if (menu.equals("exit")) {
                System.out.println("Bye!");
                break;
            }

            Object controller = iocContainer.getBean(menu);

            if(controller == null) {
                System.out.println("해당 메뉴가 존재하지 않습니다.");
                continue;
            }
            
            Method method = findRequestMapping(controller.getClass());
            if(method == null) {
                System.out.println("해당 메뉴가 존재하지 않습니다.");
                continue;
            }
            
            method.invoke(controller, keyIn);
        }
        keyIn.close();
    }

    private static Method findRequestMapping(Class<?> clazz) {
        
        Method []methods = clazz.getDeclaredMethods();
        
        for(Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            
            if(anno != null)
                return m;
        }
        return null;
    }
    private static String promptMenu() {
        System.out.print("menu > ");
        return keyIn.nextLine();
    }
}
