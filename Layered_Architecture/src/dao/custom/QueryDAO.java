package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomDTO> searchOrderByOrderID(String id)throws SQLException,ClassNotFoundException;
}
