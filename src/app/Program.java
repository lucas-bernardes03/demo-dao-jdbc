package app;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {       
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- TEST: seller findById ---");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n--- TEST: seller findByDepartment ---");
        Department dp = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dp);
        for(Seller sl : list) System.out.println(sl);
        
    }
}
