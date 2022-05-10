package dao;

import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO, String> {
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException ;
}
