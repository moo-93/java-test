package bitcamp.javatest.cms.context;

import java.lang.reflect.Method;
import java.util.HashMap;

import bitcamp.javatest.cms.annotation.RequestMapping;

public class RequestMappingHandlerMapping {
    
    HashMap<String, RequestMappingHandler> handlerMap = new HashMap<>();
    
    public void addMapping(Object instance) {
        Class<?> clazz = instance.getClass();
        
        Method []methods = clazz.getDeclaredMethods();
        
        for(Method m : methods) {
            
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            
            if(anno == null)
                continue;
            handlerMap.put(anno.value(), new RequestMappingHandler(instance, m));
        }
    }
    
    public RequestMappingHandler getMapping(String name) {
        return handlerMap.get(name);
    }
    
    public static class RequestMappingHandler {
        private Object instance;
        private Method method;
        
        public RequestMappingHandler() {}
        
        public RequestMappingHandler(Object instance, Method method) {
            this.instance = instance;
            this.method = method;
        }
        
        public Object getInstance() {
            return instance;
        }
        public Method getMethod() {
            return method;
        }
    }
}
