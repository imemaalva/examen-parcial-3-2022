package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;


public class ShoppingCart {

    private boolean itemsCount;

    private ArrayList<Item> items = new ArrayList<>();
    private int size;

    public boolean isEmpty() {
        if(items.size() == 0){
            return true;
        }
        return false;
    }

    public BigDecimal getTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;


        for(Item item: items){
                totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
            }
            return totalCost;

    }

    public void addItem(Item item) {
        if(items.size()>0 || items.size()<5){
            if(item == null || item.getProviderCode()!=""){
                items.add(item);
            }else{
                throw new InvalidDataException("Quantity must be greater than zero and lower than five");
            }
        } else {
            throw new InvalidDataException("Quantity must be greater than zero and lower than five");

        }

    }

    public boolean getItemsCount() {
        return itemsCount;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void removeItem(String itemCode2) {
    }
}
