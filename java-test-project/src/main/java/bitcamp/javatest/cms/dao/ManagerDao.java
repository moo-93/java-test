package bitcamp.javatest.cms.dao;

import java.util.List;

import bitcamp.javatest.cms.domain.Manager;

public interface ManagerDao {

    public int insert(Manager manager);
    public List<Manager> findAll();
    public Manager findByEmail(String email);
    public int delete(String email);
}
