package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.QueryDAO;
import model.CustomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomDTO> searchOrderByOrderID(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("select Orders.oid,Orders.date,Orders.customerID,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=?;", id);
        ArrayList<CustomDTO> orderRecords = new ArrayList();
        while (rst.next()) {
            orderRecords.add(new CustomDTO(rst.getString(1), LocalDate.parse(rst.getString(2)), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getBigDecimal(6)));
        }
        return orderRecords;
    }
}
