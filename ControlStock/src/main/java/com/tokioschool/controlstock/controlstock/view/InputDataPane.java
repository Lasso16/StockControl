package com.tokioschool.controlstock.controlstock.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;




public class InputDataPane extends GridPane {

    private Label idLabel, nameLabel, stockLabel;
    private TextField idTF, nameTF, stockTF;
    private ButtonPane buttonPane;

    public InputDataPane() {
        super();
        initComponents();
    }

    private void initComponents() {
        idLabel = new Label("Identificador:");
        idTF = new TextField();
        setSize(idTF);

        idTF.setEditable(false);
        nameLabel = new Label("Nombre del producto:");
        nameTF = new TextField();
        setSize(nameTF);
        stockLabel = new Label("Stock:");
        stockTF = new TextField();
        setSize(stockTF);

        buttonPane = new ButtonPane();


        setPadding(new Insets(40, 5, 5, 50));
        setVgap(10);
        add(idLabel, 0, 0);
        add(idTF, 0, 1);
        add(nameLabel, 0, 2);
        add(nameTF, 0, 3);
        add(stockLabel, 0, 4);
        add(stockTF, 0, 5);
        add(buttonPane, 0, 7);

    }

    private void setSize(TextField tf) {
        tf.setMinWidth(200);
        tf.setMaxWidth(200);
        tf.setMinHeight(30);
        tf.setMaxHeight(30);
    }
    public void clearAll() {
        idTF.clear();
        nameTF.clear();
        stockTF.clear();
    }
    public TextField getIdTF() {
        return idTF;
    }

    public TextField getNameTF() {
        return nameTF;
    }

    public TextField getStockTF() {
        return stockTF;
    }

    public ButtonPane getButtonPane() {
        return buttonPane;
    }
}
