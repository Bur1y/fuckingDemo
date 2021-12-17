package com.bur1y.best.fuckingdemo.Controllers;

import com.bur1y.best.fuckingdemo.Alerts;
import com.bur1y.best.fuckingdemo.JavaFX;
import com.bur1y.best.fuckingdemo.database.Hibernate.Interface;
import com.bur1y.best.fuckingdemo.database.table.Material;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

    private static final int COUNT_MATERIALS_ON_PAGE = 15; // константа хранящая колл элементов на одной странице

    public static Stage stage;
    public static int selectedItemId;

    public TextField searchField; // поле поиска
    public Pagination mainPaginator; // переключатель страниц
    public Label allElements; // штука показывающая выборку
    public Button updateBtn;

    ObservableList<Node> materialForms = FXCollections.observableArrayList(); // хранилище FormMaterial

    ListView<Node> materialListView;

    @FXML
    public void initialize() {
        loadData();
    }

    private Node createPage(int pageIndex) {
        // Сложный расчёт формулы количества страниц
        int fromIndex = pageIndex * COUNT_MATERIALS_ON_PAGE;
        int toIndex = Math.min(fromIndex + COUNT_MATERIALS_ON_PAGE, materialForms.size());
        ObservableList<Node> page = FXCollections.observableArrayList(materialForms.subList(fromIndex, toIndex));

        materialListView = new ListView<Node>(page);

        return materialListView;
    }

    private void loadData() {
        getListMaterials();

        mainPaginator.setPageCount(materialForms.size() / COUNT_MATERIALS_ON_PAGE + 1);
        mainPaginator.setPageFactory(this::createPage); // запихиваем в paginator
        allElements.setText(materialForms.size() + " из " + materialForms.size());
    }

    private void getListMaterials() {
        materialForms.clear();
        for (Material material : Interface.getAllMaterials()) {
            materialForms.add(FormMaterial.getMaterial(material)); // преобразуем ответ из бд в объекты
        }
    }







    public void create(ActionEvent actionEvent) throws IOException {
        createModalWindow(actionEvent, "create");
    }

    public void edit(ActionEvent actionEvent) throws IOException {
        if (materialListView.getSelectionModel().getSelectedItem() != null) {
            selectedItemId = Integer.parseInt(materialListView.getSelectionModel().getSelectedItem().getId());
            createModalWindow(actionEvent, "edit");
        } else {
            Alerts.errorAlert("Не выбранн элемент для редактирования","Ошибка","Выберите элемент из списка");
        }
    }

    public void update(ActionEvent actionEvent) {

    }

    private void createModalWindow(ActionEvent actionEvent, String fxml) throws IOException {
        stage = new Stage();
        Parent root = FXMLLoader.load(JavaFX.class.getResource(fxml + ".fxml"));
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(JavaFX.class.getResourceAsStream("icon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.showAndWait();
        loadData();
    }

}