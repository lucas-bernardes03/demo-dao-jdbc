package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.SellerDao;
import model.db.DB;
import model.db.DbException;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

    private Connection con;

    public SellerDaoJDBC(Connection con){
        this.con = con;
    }

    @Override
    public void insert(Seller dp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Seller dp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try{
            pst = con.prepareStatement(
            "SELECT seller.*,department.Name as DepName "
            + "FROM seller INNER JOIN department "
            + "ON seller.DepartmentId = department.Id "
            + "WHERE seller.Id = ?");

            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if(rs.next()){
                Department dp = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
                Seller sl = new Seller(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate"), rs.getDouble("BaseSalary"), dp);
                return sl;
            }
            
            return null;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(pst);
            DB.closeResultSet(rs);
        }
        
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
