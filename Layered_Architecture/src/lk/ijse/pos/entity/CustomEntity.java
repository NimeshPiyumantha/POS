package lk.ijse.pos.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class CustomEntity {
    private String id;
    private String name;
    private String address;

    private String code;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;

    private String oid;
    private String itemCode;
    private int qty;
//    private BigDecimal unitPrice;

//    private String oid;
    private LocalDate date;
    private String customerID;


    public CustomEntity() {
    }

    public CustomEntity(String oid, LocalDate date, String customerID, String itemCode, int qty, BigDecimal unitPrice ) {
        this.unitPrice = unitPrice;
        this.oid = oid;
        this.itemCode = itemCode;
        this.qty = qty;
        this.date = date;
        this.customerID = customerID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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
