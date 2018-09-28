import java.util.Scanner;

import bitcamp.javatest.cms.context.ApplicationContext;
import bitcamp.javatest.cms.context.RequestMappingHandlerMapping;
import bitcamp.javatest.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        ApplicationContext iocContainer =
                new ApplicationContext("bitcamp.javatest.cms.control");
        
        RequestMappingHandlerMapping requestHandlerMap =
                            new RequestMappingHandlerMapping();
        String []names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            Object obj = iocContainer.getBean(name);
            requestHandlerMap.addMapping(obj);
        }
        
        while(true) {
            String menu = promptMenu();

            if (menu.equals("exit")) {
                System.out.println("Bye!");
                break;
            }

            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);

            if( mapping== null) {
                System.out.println("해당 메뉴가 존재하지 않습니다.");
                continue;
            }
            
            mapping.getMethod().invoke(mapping.getInstance(), keyIn);
        }
        keyIn.close();
    }
    
    private static String promptMenu() {
        System.out.print("menu > ");
        return keyIn.nextLine();
    }
}
