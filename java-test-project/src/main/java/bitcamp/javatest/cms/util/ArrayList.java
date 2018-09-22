package bitcamp.javatest.cms.util;

import bitcamp.javatest.cms.domain.Student;

public class ArrayList {

    Object []list = new Object[5];
    int index = 0;

    public void add(Object obj) {

        if(index == list.length) {
            increaseStorage();
        }

        list[index++] = obj;
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

    public Object get(int no) {
        if(no < 0 || no >= index) {
            return null;
        }

        return list[no];
    }
}
