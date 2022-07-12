package dao;

import java.util.List;

import entities.Department;

public interface DepartmentDao {
    void insert(Department dp);
    void update(Department dp);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}
