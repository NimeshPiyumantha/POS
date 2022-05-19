package bo;

import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.PurchaseOrderBOImpl;


public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes boTypes) {
        switch (boTypes) {
            case ITEM:
                return new ItemBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case PurchaseOrder:
                return new PurchaseOrderBOImpl();

            default:
                return null;
        }
    }

    public enum BoTypes {
        CUSTOMER, ITEM, PurchaseOrder
    }
}


