package app;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program_SellerTest {
    public static void main(String[] args) {       
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- TEST: seller findById ---");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n--- TEST: seller findByDepartment ---");
        Department dp = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dp);
        for(Seller sl : list) System.out.println(sl);

        System.out.println("\n--- TEST: seller findAll ---");
        list = sellerDao.findAll();
        for(Seller sl : list) System.out.println(sl);

        System.out.println("\n--- TEST: seller insert ---");
        Seller newsl = new Seller(null, "Mark", "mark@gmail.com", new Date(), 6500.0, dp);
        sellerDao.insert(newsl);
        System.out.println("Inserted new id: " + newsl.getId());

        System.out.println("\n--- TEST: seller update ---");
        seller = sellerDao.findById(1);
        seller.setName("Horacio Junior");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n--- TEST: seller delete ---");
        System.out.print("Enter Id for deletion test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");


        sc.close();
    }
}
