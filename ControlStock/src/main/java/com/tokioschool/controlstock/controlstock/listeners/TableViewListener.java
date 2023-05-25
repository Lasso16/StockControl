package com.tokioschool.controlstock.controlstock.listeners;

import com.tokioschool.controlstock.controlstock.AppView;
import com.tokioschool.controlstock.controlstock.domain.Item;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class TableViewListener implements EventHandler<MouseEvent> {
    private AppView view;

    public TableViewListener(AppView view) {
        this.view = view;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (view.getTableViewPane().getTableView().getSelectionModel().getSelectedIndex() == -1) {
            view.getInputDataPane().getButtonPane().getEditButton().setDisable(true);
            return;
        }
        Item itemSelected = view.getTableViewPane().getTableView().getSelectionModel().getSelectedItem();
        view.getInputDataPane().getIdTF().setText(String.valueOf(itemSelected.getID()));
        view.getInputDataPane().getNameTF().setText(itemSelected.getName());
        view.getInputDataPane().getStockTF().setText(String.valueOf(itemSelected.getStock()));
        view.getInputDataPane().getButtonPane().getEditButton().setDisable(false);
        view.getInputDataPane().getButtonPane().getAddButton().setDisable(true);
        view.getInputDataPane().getButtonPane().getCancelButton().setDisable(false);

    }
}
