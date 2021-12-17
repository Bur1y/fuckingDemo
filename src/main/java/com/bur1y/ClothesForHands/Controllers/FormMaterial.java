package com.bur1y.ClothesForHands.Controllers;

import com.bur1y.ClothesForHands.JavaFX;
import com.bur1y.ClothesForHands.database.table.Material;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class FormMaterial extends ListCell<Material> {

    public static Node getMaterial(Material material) {

        VBox nodeParent = new VBox();
        nodeParent.setId(material.getId().toString());
        nodeParent.setStyle("-fx-border-color: black;");

        HBox nodeMain = new HBox();
        VBox.setVgrow(nodeMain, Priority.ALWAYS);

        VBox.setMargin(nodeMain, new Insets(10));
        CheckBox checkBox = new CheckBox();
        ImageView imageView = new ImageView();
        VBox.setVgrow(imageView, Priority.ALWAYS);
        try {
            imageView.setImage(new Image(JavaFX.class.getResourceAsStream(material.getImage())));
        } catch (Exception e) {
            //e.printStackTrace();
            imageView.setImage(new Image(String.valueOf(JavaFX.class.getResource("/materials/null.png"))));
        }

        imageView.setFitHeight(55.0);
        imageView.setFitWidth(100.0);

        HBox.setMargin(imageView, new Insets(0, 15, 0, 0));

        VBox nodeTitles = new VBox();
        HBox.setHgrow(nodeTitles, Priority.ALWAYS);

        HBox nodeTitleFirst = new HBox(10);
        Label typeMaterial = new Label(material.getMaterialTypeID().getTitle()); // "тип материала"
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        Label nameMaterial = new Label(material.getTitle()); // "Наименование материала"
        nodeTitleFirst.getChildren().addAll(typeMaterial, separator, nameMaterial);

        HBox nodeTitleSecond = new HBox(10);
        Label minCount = new Label("Минимальное количество: " + material.getMinCount() + " шт");
        nodeTitleSecond.getChildren().addAll(minCount);

        HBox nodeTitleThird = new HBox(10);
        Label nameSupplier = new Label("Поставщики");
        nodeTitleThird.getChildren().addAll(nameSupplier);

        nodeTitles.getChildren().addAll(nodeTitleFirst, nodeTitleSecond, nodeTitleThird);

        VBox nodeEnd = new VBox();
        Label materialCount = new Label("Остаток: " + material.getCountInStock());
        nodeEnd.getChildren().addAll(materialCount);
        HBox.setMargin(nodeEnd, new Insets(0, 0, 0, 15));
        nodeEnd.setMaxHeight(1000);

        if (material.getCountInStock() < material.getMinCount()) {
            nodeParent.setStyle("-fx-background-color: #f19292;");
        } else if (material.getCountInStock() > material.getMinCount() * 3) {
            nodeParent.setStyle("-fx-background-color: #ffba01;");
        }

        nodeMain.getChildren().addAll(checkBox,imageView, nodeTitles, nodeEnd);
        nodeParent.getChildren().addAll(nodeMain);
        return nodeParent;
    }
}
