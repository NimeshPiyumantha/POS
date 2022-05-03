package dao;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    String generateNewCode() throws SQLException, ClassNotFoundException;
}
