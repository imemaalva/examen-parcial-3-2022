package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;

public class Item {
    private String code;
    private int quantity;
    private String providerCode;
    private BigDecimal unitCost;

    public Item(){

    }

    public Item(String code, String providerCode, BigDecimal unitCost, int quantity) {
        if (quantity < 0 || quantity > 5) {
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }
        this.code = code;
        this.quantity = quantity;
        this.providerCode = providerCode;
        this.unitCost = unitCost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }
}
