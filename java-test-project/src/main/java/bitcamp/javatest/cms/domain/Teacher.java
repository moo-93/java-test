package bitcamp.javatest.cms.domain;

@SuppressWarnings("serial")
public class Teacher extends Member{
    protected int pay;
    protected String subjects;

    public int getPay() {
        return pay;
    }
    public void setPay(int pay) {
        this.pay = pay;
    }
    public String getSubjects() {
        return subjects;
    }
    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
