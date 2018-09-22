package bitcamp.javatest.cms.util;

import bitcamp.javatest.cms.domain.Student;

public class ArrayList<T> {

    private Object []list = new Object[5];
    private int index = 0;

    public void add(T t) {

        if(index == list.length) {
            increaseStorage();
        }

        list[index++] = t;
    }

    private void increaseStorage() {

        Object []newList = new Student[list.length + 3];

        for(int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }

    public void remove(int no) {
        if(no < 0 || no >= index) {
            return;
        }

        for(int i = no; i < index - 1; i++) {
            list[i] = list[i+1];
        }

        index--;
    }

    public int size() {
        return index;
    }

    @SuppressWarnings("unchecked")
    public T get(int no) {
        if(no < 0 || no >= index) {
            return null;
        }

        return (T)list[no];
    }
}
