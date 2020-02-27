package com.tr.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private String itemCode;
    private String itemName;
    private BigDecimal price;
    private int stock;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getStock() == item.getStock() &&
                getItemCode().equals(item.getItemCode()) &&
                getItemName().equals(item.getItemName()) &&
                getPrice().equals(item.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemCode(), getItemName(), getPrice(), getStock());
    }
}
