package bitcamp.javatest.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;

@Component
public class AutowiredAnnotationBeanPostProcessor implements BeanPostProcessor{

    Map<String, Object> beanContainer;

    public void postProcess(ApplicationContext beanContainer) {
        Collection<Object> objList = beanContainer.objPool.values();

        for(Object obj : objList) {

            Method[] methods = obj.getClass().getDeclaredMethods();
            for(Method m : methods) {
                if(!m.isAnnotationPresent(Autowired.class)) continue;

                Class<?> paramType = m.getParameterTypes()[0];

                Object dependency = beanContainer.getBean(paramType);

                if(dependency == null) continue;

                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() 호출됨. \n", m.getName());
                } catch (Exception e) {}
            }
        }
    }
}
