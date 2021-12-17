package com.bur1y.ClothesForHands.Controllers;

import com.bur1y.ClothesForHands.database.table.MaterialType;
import com.bur1y.ClothesForHands.database.Hibernate.Interface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateModal {

    public TextField name;
    public TextField countOnStorage;
    public TextField unit;
    public TextField countInStack;
    public TextField minCount;
    public TextField cost;
    public TextField image;
    public TextArea description;
    public ChoiceBox typeMaterial;

    public void save(ActionEvent actionEvent) {
        MainWindow.stage.close();
    }

    private void loadComboBox() {
        ObservableList<MaterialType> mt = FXCollections.observableArrayList(
                Interface.getAllMaterialTypes()
        );
        typeMaterial.setItems(mt);
    }

    public void initialize(){
        loadComboBox();
    }
}
