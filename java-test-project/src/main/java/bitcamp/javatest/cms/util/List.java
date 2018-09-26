package bitcamp.javatest.cms.util;

public interface List<T> {
    
    void add(T t);
    T get(int index);
    T remove(int index);
    int size();
    default void insert(int index, T t) {
        
    }
    
}
