package app;

import java.util.Date;
import java.util.List;

import com.mysql.cj.log.Slf4JLogger;

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

        System.out.println("\n--- TEST: seller findAll ---");
        list = sellerDao.findAll();
        for(Seller sl : list) System.out.println(sl);

        System.out.println("\n--- TEST: seller insert ---");
        Seller newsl = new Seller(null, "Mark", "mark@gmail.com", new Date(), 6500.0, dp);
        sellerDao.insert(newsl);
        System.out.println("Inserted new id: " + newsl.getId());

    }
}
