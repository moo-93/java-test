package bitcamp.javatest.cms.domain;

@SuppressWarnings("serial")
public class Student extends Member{
    protected String school;
    protected boolean working;

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public boolean isWorking() {
        return working;
    }
    public void setWorking(boolean working) {
        this.working = working;
    }
}
