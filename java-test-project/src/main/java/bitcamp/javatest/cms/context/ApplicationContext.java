package bitcamp.javatest.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import bitcamp.javatest.cms.annotation.Component;

public class ApplicationContext {
    
    HashMap<String, Object> objPool = new HashMap<>();
    
    public ApplicationContext(String pakageName) throws Exception{
        
        String path = pakageName.replace(".", "/");
        
        File file = Resources.getResourceAsFile(path);
        
        findClass(file, path);
    }
    
    public String[] getBeanDefinitionNames(){
        Set<String> keySet = objPool.keySet();
        String []names = new String[keySet.size()];
        keySet.toArray(names);
        return names;
    }
    
    public Object getBean(String name) {
        return (Object)objPool.get(name);
    }
    
    private void findClass(File filePath, String packagePath) throws Exception{
        File[] files = filePath.listFiles();
        for(File file: files) {
            if(file.isDirectory())
                findClass(file, packagePath + "/" +file.getName());
            else {
                String className = (packagePath + "/" + file.getName())
                                    .replace("/", ".")
                                    .replace(".class", "");
                
                Class<?> clazz = Class.forName(className);
                
                if(clazz.isInterface()) continue;
                
                try {
                    Constructor<?> constructor = clazz.getConstructor();
                    Object instance = constructor.newInstance();
                    Component anno = clazz.getAnnotation(Component.class);
                    if(anno.value().length()>0)
                        objPool.put(anno.value(), instance);
                    else 
                        objPool.put(clazz.getName(), instance);
                } catch(Exception e) {
                    System.out.printf("%s 클래스는 기본 생성자가 없습니다.\n", clazz.getName());
                }
            }
        }
    }
    
}
