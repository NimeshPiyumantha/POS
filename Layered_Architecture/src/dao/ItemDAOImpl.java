package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO>allItem=new ArrayList<>();
        while (rst.next()) {
            String code=rst.getString(1);
            String description=rst.getString(2);
            BigDecimal unitPrice=rst.getBigDecimal(3);
            int qtyOnHand=rst.getInt(4);
            allItem.add(new ItemDTO(code,description,unitPrice,qtyOnHand));
        }
        return allItem;
    }

    public int updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1, dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setString(3, dto.getAddress());
        return pstm.executeUpdate();
    }
}
