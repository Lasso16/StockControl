package com.tokioschool.controlstock.controlstock.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class StatusBarPane extends BorderPane {

    private Label messageLabel, versionLabel;

    public StatusBarPane() {
        super();

        initComponents();
    }

    private void initComponents() {
        messageLabel = new Label(" ");
        versionLabel = new Label("Control de Stock V1.0");

        setPadding(new Insets(0, 20, 0, 20));
        setLeft(messageLabel);
        setRight(versionLabel);
    }

    public Label getMessageLabel() {
        return messageLabel;
    }
}
