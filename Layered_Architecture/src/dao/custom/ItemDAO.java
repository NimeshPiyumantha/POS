package dao.custom;

import dao.CrudDAO;
import entity.Item;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface ItemDAO extends CrudDAO<Item, String> {
    ArrayList<Item> getItemFromPrice(double price) throws ClassNotFoundException, SQLException;
}
