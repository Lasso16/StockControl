package com.tokioschool.controlstock.controlstock.listeners;

import com.tokioschool.controlstock.controlstock.AppController;
import com.tokioschool.controlstock.controlstock.AppView;
import com.tokioschool.controlstock.controlstock.domain.Item;
import com.tokioschool.controlstock.controlstock.model.DataBase;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ButtonListeners implements EventHandler<ActionEvent> {

    private AppView view;
    private DataBase model;
    private AppController controller;
    private boolean isNew;


    public ButtonListeners(AppView view, DataBase model, AppController controller) {
        this.view = view;
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        String userData = node.getUserData().toString();
        switch (userData) {
            case "add":
                view.getInputDataPane().getIdTF().setText(String.valueOf(model.setID()));
                view.setEditMode(true);
                isNew = true;
                break;
            case "edit":
                editItem();
                break;
            case "cancel":
                view.setEditMode(false);
                view.getInputDataPane().clearAll();
                view.getInputDataPane().getButtonPane().getEditButton().setDisable(true);
                break;
            case "save":
                saveItem();

                break;
        }
    }
    private void editItem() {
        Item item = view.getTableViewPane().getTableView().getSelectionModel().getSelectedItem();
        view.setEditMode(true);
        view.getInputDataPane().getButtonPane().getEditButton().setDisable(true);
        model.getItemList().remove(item);
        try {
            CSVPrinter csvPrinter = new CSVPrinter(Files.newBufferedWriter(Paths.get(model.getDbFile())), CSVFormat.newFormat(';')
                    .withRecordSeparator("\n"));
            for (Item item1 : model.getItemList()) {
                csvPrinter.printRecord(item1.getID(), item1.getName(), item1.getStock());
            }
            csvPrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isNew = false;
    }

    private void saveItem() {
        //controller.correctStock();
        if (view.getInputDataPane().getNameTF().getText().isEmpty() || view.getInputDataPane().getStockTF().getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Rellene todos los campos").show();
            return;
        }
        if (!controller.correctStock()) {
            new Alert(Alert.AlertType.ERROR, "Ponga una cantidad válida").show();
            return;
        }
        model.addItem(new Item(Integer.parseInt(view.getInputDataPane().getIdTF().getText()),
                view.getInputDataPane().getNameTF().getText(),
                Integer.parseInt(view.getInputDataPane().getStockTF().getText())));
        if (isNew) {
            view.getStatusBarPane().getMessageLabel().setText("Producto añadido correctamente");

        } else {
            view.getStatusBarPane().getMessageLabel().setText("Producto modificado correctamente");
        }
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), actionEvent ->
                view.getStatusBarPane().getMessageLabel().setText("")));
        timeline.setCycleCount(1);
        timeline.play();


        controller.showData();
        view.setEditMode(false);
        view.getInputDataPane().clearAll();
    }


}

