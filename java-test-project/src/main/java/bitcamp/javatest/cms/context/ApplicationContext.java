package bitcamp.javatest.cms.context;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

public class ApplicationContext {
    
    HashMap<String, Object> objpool = new HashMap<>();
    
    public ApplicationContext(String pakageName) throws IOException{
        
        String path = pakageName.replace(".", "/");
        
        File file = Resources.getResourceAsFile(path);
        System.out.println(file.getAbsolutePath());
    }
    
    public Object get(String name) {
        return null;
    }
}
