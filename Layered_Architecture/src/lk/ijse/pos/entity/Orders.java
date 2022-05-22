package lk.ijse.pos.entity;

import java.time.LocalDate;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class Orders {
    private String oid;
    private LocalDate date;
    private String customerID;

    public Orders() {
    }

    public Orders(String oid, LocalDate date, String customerID) {
        this.oid = oid;
        this.date = date;
        this.customerID = customerID;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
