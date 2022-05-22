package dao.custom;

import dao.CrudDAO;
import entity.Customer;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerDAO extends CrudDAO<Customer, String> {
    ArrayList<Customer> getAllCustomersByAddress(String address) throws ClassNotFoundException, SQLException;
}
