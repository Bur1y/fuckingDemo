package com.bur1y.best.fuckingdemo;

public class Alerts {
    /**
     * Метод для вывода окна об ошибке
     *
     * @param errMsg     Сообщение
     * @param errTitle   Название окна
     * @param errContent Контекст
     */
    public static void errorAlert(String errMsg, String errTitle, String errContent) {
        javafx.scene.control.Alert error = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR); // Создаём

        error.setTitle(errTitle);
        error.setHeaderText(errMsg);
        error.setContentText(errContent);

        error.showAndWait();
    }
}
