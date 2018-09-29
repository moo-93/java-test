package bitcamp.javatest.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;

public class ApplicationContext {

    HashMap<String, Object> objPool = new HashMap<>();
    List<Class<?>> classes = new ArrayList<>();

    public ApplicationContext(String pakageName) throws Exception{

        String path = pakageName.replace(".", "/");

        File file = Resources.getResourceAsFile(path);

        findClass(file, path);

        createInstance();

        injectDependency();
    }

    public String[] getBeanDefinitionNames(){
        Set<String> keySet = objPool.keySet();
        String []names = new String[keySet.size()];
        keySet.toArray(names);
        return names;
    }

    public Object getBean(Class<?> type) {
        Collection<Object> objList = objPool.values();
        for(Object obj : objList) {
            if(type.isInstance(obj))
                return obj;
        }
        return null;
    }
    public Object getBean(String name) {
        return objPool.get(name);
    }

    private void findClass(File filePath, String packagePath) {
        File[] files = filePath.listFiles();
        for(File file: files) {
            if(file.isDirectory())
                findClass(file, packagePath + "/" +file.getName());
            else {
                String className = (packagePath + "/" + file.getName())
                        .replace("/", ".")
                        .replace(".class", "");

                try {
                    Class<?> clazz = Class.forName(className);

                    classes.add(clazz);
                } catch(Exception e) {}
            }
        }
    }
    
    private void createInstance() {
        for(Class<?> clazz : classes) {
            if(clazz.isInterface()) continue;
            
            Component anno = clazz.getAnnotation(Component.class);
            
            if(anno == null) continue;
            
            try {
                Constructor<?> constructor = clazz.getConstructor();
                
                Object instance = constructor.newInstance();
                
                if(anno.value().length()>0)
                    objPool.put(anno.value(), instance);
                else 
                    objPool.put(clazz.getName(), instance);
            } catch(Exception e) {
                System.out.printf("%s 클래스는 기본 생성자가 없습니다.\n", clazz.getName());
            }
        }
    }
    
    private void injectDependency() {
        
        Collection<Object> objList = objPool.values();
        
        for(Object obj : objList) {
            
            Method[] methods = obj.getClass().getDeclaredMethods();
            for(Method m : methods) {
                if(!m.isAnnotationPresent(Autowired.class)) continue;
                
                Class<?> paramType = m.getParameterTypes()[0];
                
                Object dependency = getBean(paramType);
                
                if(dependency == null) continue;
                
                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() 호출됨. \n", m.getName());
                } catch (Exception e) {}
            }
        }
    }

}
