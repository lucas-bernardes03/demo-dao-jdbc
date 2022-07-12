package app;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Department dp = new Department(1, "Computers");
        Seller sl = new Seller(33, "Lucas", "lucas@gmail.com", new Date(), 4500.0, dp);
        
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println(sl);
    }
}
