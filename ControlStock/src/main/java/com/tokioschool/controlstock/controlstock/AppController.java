package com.tokioschool.controlstock.controlstock;

;
import com.tokioschool.controlstock.controlstock.listeners.ButtonListeners;

import com.tokioschool.controlstock.controlstock.listeners.TableViewListener;
import com.tokioschool.controlstock.controlstock.model.DataBase;
import javafx.scene.control.Alert;


public class AppController {

    private AppView view;
    private DataBase model;

    public AppController(AppView view, DataBase model) {
        this.view = view;
        this.model = model;
        addActions();
        showData();
    }

    public void showData() {
        view.getTableViewPane().getTableView().getItems().clear();
        view.getTableViewPane().getTableView().getItems().addAll(model.getItemList());

    }

    private void addActions() {
        ButtonListeners buttonListeners = new ButtonListeners(view, model, this);
        view.getInputDataPane().getButtonPane().getAddButton().setOnAction(buttonListeners);
        view.getInputDataPane().getButtonPane().getEditButton().setOnAction(buttonListeners);
        view.getInputDataPane().getButtonPane().getCancelButton().setOnAction(buttonListeners);
        view.getInputDataPane().getButtonPane().getSaveButton().setOnAction(buttonListeners);

        view.getTableViewPane().getTableView().setOnMouseClicked(new TableViewListener(view));

    }

    public boolean correctStock() {
        String aux = view.getInputDataPane().getStockTF().getText();
        return aux.matches("[0-9]+");
    }

    //TODO contextualMenu


}


