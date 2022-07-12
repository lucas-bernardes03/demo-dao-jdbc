package dao;

import java.util.List;

import entities.Seller;

public interface SellerDao {
    void insert(Seller dp);
    void update(Seller dp);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
}
