package dao.custom.impl;

import dao.custom.QueryDAO;

import java.sql.SQLException;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class QueryDAOImpl implements QueryDAO {

    @Override
    public void searchOrderByOrderID(String id)throws SQLException,ClassNotFoundException{
        String sql="select Orders.oid,Orders.date,Orders.customerID,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=\"OID-001\";";
    }
}
