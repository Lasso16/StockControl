package com.tokioschool.controlstock.controlstock.domain;

import com.tokioschool.controlstock.controlstock.model.DataBase;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {

    private SimpleIntegerProperty ID;
    private SimpleStringProperty name;
    private SimpleIntegerProperty stock;

    public Item(int ID, String name, int stock) {
        this.ID = new SimpleIntegerProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.stock = new SimpleIntegerProperty(stock);
    }

    public int getID() {
        return ID.get();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getStock() {
        return stock.get();
    }

    public void setStock(int quantity) {
        stock.set(quantity);
    }


}
