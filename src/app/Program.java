package app;

import java.util.Date;

import entities.Department;
import entities.Seller;

public class Program {
    public static void main(String[] args) {
        Department dp = new Department(1, "Computers");
        Seller sl = new Seller(33, "Lucas", "lucas@gmail.com", new Date(), 4500.0, dp);
        
        System.out.println(sl);
    }
}
