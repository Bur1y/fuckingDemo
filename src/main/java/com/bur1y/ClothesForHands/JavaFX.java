package com.bur1y.ClothesForHands;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFX extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFX.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.getIcons().add(new Image(JavaFX.class.getResourceAsStream("icon.png")));
        stage.setTitle("Clothse For Hands");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException { //метод позволяющий менять сцены
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent getRoot() { //метод, который возвращает элемент Parent. (Позволяет из любого класса получить доступ к корню scene)
        return scene.getRoot();
    }

    private static Parent loadFXML(String fxml) throws IOException { //метод подгружает FXML файл
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFX.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void runApp() {
        launch();
    }
}
