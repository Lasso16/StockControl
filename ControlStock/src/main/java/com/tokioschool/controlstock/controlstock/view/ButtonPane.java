package com.tokioschool.controlstock.controlstock.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane extends HBox {

    private Button addButton, editButton, cancelButton, saveButton;

    public ButtonPane() {
        super();

        initComponents();
    }

    private void initComponents() {
        addButton = new Button("Añadir");
        addButton.setUserData("add");
        editButton = new Button("Editar");
        editButton.setUserData("edit");
        editButton.setDisable(true);
        cancelButton = new Button("Cancelar");
        cancelButton.setUserData("cancel");
        saveButton = new Button("Guardar");
        saveButton.setUserData("save");



        setSpacing(5);
        setPadding(new Insets(0, 0, 0, 20));

        getChildren().addAll(addButton, editButton, saveButton, cancelButton);
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }


}
