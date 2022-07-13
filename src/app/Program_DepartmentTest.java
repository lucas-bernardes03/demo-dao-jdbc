package app;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program_DepartmentTest {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("--- TEST: department findById ---");
        Department dp = departmentDao.findById(3);
        System.out.println(dp);

        System.out.println("\n--- TEST: department insert ---");
        departmentDao.insert(new Department(null, "Cooking"));
        System.out.println("Insert complete.");

        System.out.println("\n--- TEST: department update ---");
        dp.setName("Fishing");
        departmentDao.update(dp);
        System.out.println("Update complete.");

        System.out.println("\n--- TEST: department findAll ---");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        for(Department d : list) System.out.println(d);
        
        System.out.println("\n--- TEST: department delete ---");
        departmentDao.deleteById(6);
        System.out.println("Delete complete");

    }
}
