package bitcamp.javatest.cms.control.teacher;

import java.util.Scanner;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.dao.TeacherDao;
import bitcamp.javatest.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    TeacherDao teacherDao;

    @Autowired
    public void setTeahcerDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {

        System.out.print("조회할 이메일 > ");
        String email = keyIn.nextLine();

        Teacher t = teacherDao.findByEmail(email);
        
        if(t == null) {
            System.out.println("해당 이메일의 선생 정보가 존재하지 않습니다.");
            return ;
        }

        System.out.printf("이름 : %s ", t.getName());
        System.out.printf("이메일 : %s ", t.getEmail());
        System.out.printf("암호 : %s ", t.getPassword());
        System.out.printf("전화 : %s ", t.getTel());
        System.out.printf("시급 : %d ", t.getPay());
        System.out.printf("강의과목 : %s\n",t.getSubjects());
    }
}
