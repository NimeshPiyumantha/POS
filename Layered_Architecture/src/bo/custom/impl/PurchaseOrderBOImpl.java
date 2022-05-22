package bo.custom.impl;

import bo.custom.PurchaseOrderBO;
import dao.DAOFactory;
import dao.custom.*;
import db.DBConnection;
import entity.Customer;
import entity.Item;
import entity.OrderDetails;
import entity.Orders;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    //Hiding the object creation logic using the Factory pattern
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);// hide the object creation logic through the factory
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);


    //Exposed the object creation logic
    //private final ItemDAO itemDAO = new ItemDAOImpl();
    //private final OrderDAO orderDAO = new OrderDAOImpl();
    //private final OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    //private final QueryDAO queryDAO = new QueryDAOImpl();


    @Override
    public boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {

        /*Transaction*/
        Connection connection = DBConnection.getDbConnection().getConnection();
        /*if order id already exist*/
        if (orderDAO.exist(dto.getOrderId())) {

        }
        connection.setAutoCommit(false);
        boolean save = orderDAO.save(new Orders(dto.getOrderId(), dto.getOrderDate(), dto.getCustomerId()));

        if (!save) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        for (OrderDetailDTO detail : dto.getOrderDetails()) {
            boolean save1 = orderDetailsDAO.save(new OrderDetails(detail.getOid(), detail.getItemCode(), detail.getQty(), detail.getUnitPrice()));
            if (!save1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            //Search & Update Item
            ItemDTO item = searchItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            //update item
            boolean update = itemDAO.update(new Item(item.getCode(), item.getDescription(), item.getQtyOnHand(), item.getUnitPrice()));

            if (!update) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }
        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer ent = customerDAO.search(id);
        return new CustomerDTO(ent.getId(), ent.getName(), ent.getAddress());
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item ent = itemDAO.search(code);
        return new ItemDTO(ent.getCode(), ent.getDescription(), ent.getUnitPrice(), ent.getQtyOnHand());
    }

    @Override
    public boolean checkItemIsAvailable(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public String generateNewOrderID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        for (Customer ent : all) {
            allCustomers.add(new CustomerDTO(ent.getId(), ent.getName(), ent.getAddress()));
        }
        return allCustomers;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item ent : all) {
            allItems.add(new ItemDTO(ent.getCode(), ent.getDescription(), ent.getUnitPrice(), ent.getQtyOnHand()));
        }
        return allItems;
    }

}
