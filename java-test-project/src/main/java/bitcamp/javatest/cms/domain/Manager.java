package bitcamp.javatest.cms.domain;

@SuppressWarnings("serial")
public class Manager extends Member{
    protected String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}