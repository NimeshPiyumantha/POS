package lk.ijse.pos.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class OrderDetailDTO implements Serializable {

    private String oid;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String itemCode, int qty, BigDecimal unitPrice) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetailDTO(String oid, String itemCode, int qty, BigDecimal unitPrice) {
        this.oid = oid;
        this.itemCode = itemCode;
        this.qty = qty;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderDetailDTO{");
        sb.append("oid='").append(oid).append('\'');
        sb.append(", itemCode='").append(itemCode).append('\'');
        sb.append(", qty=").append(qty);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append('}');
        return sb.toString();
    }
}
