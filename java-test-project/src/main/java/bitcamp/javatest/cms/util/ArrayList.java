package bitcamp.javatest.cms.util;

public class ArrayList<T> implements List<T>{

    private Object []list = new Object[5];
    private int index = 0;

    public void add(T t) {

        if(index == list.length) {
            increaseStorage();
        }

        list[index++] = t;
    }

    private void increaseStorage() {

        Object []newList = new Object[list.length + 3];

        for(int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }

    @SuppressWarnings("unchecked")
    public T remove(int no) {
        if(no < 0 || no >= index) {
            return null;
        }

        for(int i = no; i < index - 1; i++) {
            list[i] = list[i+1];
        }

        index--;
        return (T)list[no];
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
