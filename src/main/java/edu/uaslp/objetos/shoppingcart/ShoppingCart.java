package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

    private List<Item> items = new ArrayList<>();
    private int size;

    public boolean isEmpty() {
        if(items.size() == 0){
            return true;
        }
        return false;
    }

    public BigDecimal getTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;

        if(items.isEmpty()){
            throw new EmptyShoppingCartException("Empty shopping car");
        }
        for(Item item: items){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        return totalCost;


    }

    public void addItem(Item item) {

        BigDecimal aux = new BigDecimal(0);


            if(item.getCode() == null){
                throw new InvalidDataException("Null or empty string not allowed for item code");
            }if( item.getProviderCode()==""){
                throw new InvalidDataException("Null or empty string not allowed for provider code");
            }if(item.getUnitCost().compareTo(aux) == -1){
                throw new InvalidDataException("Cost must be greater than zero");
            }

        for(Item existentItem: items){
            if(existentItem.getCode().equals(item.getCode()) && existentItem.getUnitCost().compareTo(item.getUnitCost()) == 0){
               existentItem.setQuantity(existentItem.getQuantity() + item.getQuantity() );
               return;
            }
        }
        items.add(item);
    }

    public int getItemsCount() {
        int itemsCount = 0;

        for(Item item: items){
            itemsCount += item.getQuantity();
        }
        return itemsCount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void removeItem(String itemCode2) {

        for(Item removeItem: items){
            if(removeItem.getCode() == itemCode2){
                items.remove(itemCode2);
                removeItem.setQuantity(removeItem.getQuantity()-1);
                if(removeItem.getQuantity()==0){
                    items.remove(removeItem);
                }
            }
        }
    }
}
