package bo;

import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class CustomerBOImpl {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(dto);
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }

    public boolean customerExist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    public String generateNewCustomerID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }

}
