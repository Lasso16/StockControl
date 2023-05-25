package com.tokioschool.controlstock.controlstock;

import com.tokioschool.controlstock.controlstock.view.InputDataPane;
import com.tokioschool.controlstock.controlstock.view.StatusBarPane;
import com.tokioschool.controlstock.controlstock.view.TableViewPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppView {
    private BorderPane borderPane;
    private InputDataPane inputDataPane;
    private TableViewPane tableViewPane;
    private StatusBarPane statusBarPane;

    public AppView(Stage stage) {
        initComponents();
        setEditMode(false);
        Scene scene = new Scene(borderPane, 600, 300);
        stage.setScene(scene);

        stage.setTitle("Control de Stock");
        stage.show();
    }

    private void initComponents() {
        inputDataPane = new InputDataPane();
        borderPane = new BorderPane();
        tableViewPane = new TableViewPane();
        statusBarPane = new StatusBarPane();

        borderPane.setLeft(inputDataPane);
        borderPane.setRight(tableViewPane);
        borderPane.setBottom(statusBarPane);
    }

    public void setEditMode(boolean editMode) {
        inputDataPane.getButtonPane().getAddButton().setDisable(editMode);
        inputDataPane.getButtonPane().getSaveButton().setDisable(!editMode);
        inputDataPane.getButtonPane().getCancelButton().setDisable(!editMode);
        inputDataPane.getIdTF().setDisable(!editMode);
        inputDataPane.getNameTF().setDisable(!editMode);
        inputDataPane.getStockTF().setDisable(!editMode);
        if (!editMode) {
            inputDataPane.getButtonPane().getAddButton().requestFocus();
        } else
            inputDataPane.getButtonPane().getSaveButton().requestFocus();

    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public InputDataPane getInputDataPane() {
        return inputDataPane;
    }

    public void setInputDataPane(InputDataPane inputDataPane) {
        this.inputDataPane = inputDataPane;
    }

    public TableViewPane getTableViewPane() {
        return tableViewPane;
    }

    public void setTableViewPane(TableViewPane tableViewPane) {
        this.tableViewPane = tableViewPane;
    }

    public StatusBarPane getStatusBarPane() {
        return statusBarPane;
    }

    public void setStatusBarPane(StatusBarPane statusBarPane) {
        this.statusBarPane = statusBarPane;
    }
}
