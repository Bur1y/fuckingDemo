package com.bur1y.ClothesForHands.Controllers;

import com.bur1y.ClothesForHands.database.Hibernate.Interface;
import com.bur1y.ClothesForHands.database.table.Material;
import com.bur1y.ClothesForHands.database.table.MaterialType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditModal {

    public TextField name;
    public TextField countOnStorage;
    public TextField unit;
    public TextField countInStack;
    public TextField minCount;
    public TextField cost;
    public TextField image;
    public TextArea  description;
    public ChoiceBox typeMaterial;

    private Material m;

    public void initialize() {
        loadComboBox();
        m = Interface.getMaterial(MainWindow.selectedItemId);
        loadMaterial(m);
    }

    private void loadMaterial(Material material){
        name.setText(material.getTitle());
        countOnStorage.setText(String.valueOf(material.getCountInStock()));
        unit.setText(material.getUnit());
        countInStack.setText(String.valueOf(material.getCountInPack()));
        minCount.setText(String.valueOf(material.getMinCount()));
        cost.setText(String.valueOf(material.getCost()));
        image.setText(material.getImage());
        description.setText(material.getDescription());
        typeMaterial.setValue(material.getMaterialTypeID().getTitle());
    }

    private void loadComboBox() {
        ObservableList<MaterialType> mt = FXCollections.observableArrayList(
                Interface.getAllMaterialTypes()
        );
        typeMaterial.setItems(mt);
    }

    public void saveEdit(ActionEvent actionEvent) {
        m.setTitle(name.getText());
        m.setCountInStock(Double.valueOf(countOnStorage.getText()));
        m.setImage(image.getText());
        Interface.updateMaterial(m);
        MainWindow.stage.close();
    }

    public void delete(ActionEvent actionEvent) {
        Interface.deleteMaterial(Interface.getMaterial(MainWindow.selectedItemId));
        MainWindow.stage.close();
    }
}
