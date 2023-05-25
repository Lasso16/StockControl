package com.tokioschool.controlstock.controlstock.view;

import com.tokioschool.controlstock.controlstock.domain.Item;
import javafx.geometry.Insets;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class TableViewPane extends VBox {

    private TableView<Item> tableView;
    private TableColumn<Item, Integer> idTC, stockTC;
    private TableColumn<Item, String> nameTC;

    public TableViewPane() {
        super();

        initComponents();
    }

    private void initComponents() {
        tableView = new TableView<>();
        tableView.setEditable(true);


        idTC = new TableColumn<>("ID");
        idTC.setCellValueFactory(new PropertyValueFactory<Item, Integer>("ID"));
        nameTC = new TableColumn<>("Producto");
        nameTC.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        stockTC = new TableColumn<>("Cantidad");
        stockTC.setCellValueFactory(new PropertyValueFactory<Item, Integer>("stock"));

        setPadding(new Insets(0, 30,20, 0));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.getColumns().addAll(idTC, nameTC, stockTC);
        getChildren().add(tableView);
    }


    public TableView<Item> getTableView() {
        return tableView;
    }

    public TableColumn<Item, Integer> getIdTC() {
        return idTC;
    }

    public TableColumn<Item, Integer> getStockTC() {
        return stockTC;
    }

    public TableColumn<Item, String> getNameTC() {
        return nameTC;
    }

    public void setTableView(TableView<Item> tableView) {
        this.tableView = tableView;
    }

    public void setIdTC(TableColumn<Item, Integer> idTC) {
        this.idTC = idTC;
    }

    public void setStockTC(TableColumn<Item, Integer> stockTC) {
        this.stockTC = stockTC;
    }

    public void setNameTC(TableColumn<Item, String> nameTC) {
        this.nameTC = nameTC;
    }
}
