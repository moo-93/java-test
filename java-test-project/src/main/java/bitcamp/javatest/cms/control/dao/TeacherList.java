package bitcamp.javatest.cms.control.dao;

import bitcamp.javatest.cms.domain.Teacher;

public class TeacherList {

    static Teacher []teachers = new Teacher[5];
    static int teaherIndex = 0;
    
    public static void add(Teacher teacher) {
        
        if(teaherIndex == teachers.length) {
            increaseStorage();
        }
        
        teachers[teaherIndex++] = teacher;
    }
    
    private static void increaseStorage() {

        Teacher []newList = new Teacher[teachers.length + 3];

        for(int i = 0; i < teachers.length; i++) {
            newList[i] = teachers[i];
        }

        teachers = newList;
    }
    
    public static void remove(int no) {
        if(no < 0 || no >= teaherIndex) {
            return;
        }
        
        for(int i = no; i < teaherIndex - 1; i++) {
            teachers[i] = teachers[i+1];
        }
        
        teaherIndex--;
    }
    
    public static int size() {
        return teaherIndex;
    }
    
    public static Teacher get(int no) {
        if(no < 0 || no >= teaherIndex) {
            return null;
        }
        
        return teachers[no];
    }
}
