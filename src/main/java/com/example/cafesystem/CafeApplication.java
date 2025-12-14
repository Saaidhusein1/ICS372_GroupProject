package com.example.cafesystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CafeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("Panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        stage.setTitle("System Panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void BarristaScene(ActionEvent event) throws IOException {
        Stage stage1 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("barista_login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        stage1.setTitle("Barista Login");
        stage1.setScene(scene);
        stage1.show();
    }

    @FXML
    public void ManagerScene(ActionEvent event) throws IOException {
        Stage stage1 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("manager_login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        stage1.setTitle("Manager Login");
        stage1.setScene(scene);
        stage1.show();
    }

    @FXML
    public void CustomerScene(ActionEvent event) throws IOException {
        Stage stage1 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("SetName.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        stage1.setTitle("Set Name");
        stage1.setScene(scene);
        stage1.show();
    }

    @FXML
    public void showCustomerMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("CustomerMain.fxml"));
        Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 503 , 375);
        stage_new.setTitle("Customer Main");
        stage_new.setScene(scene_new);
        stage_new.show();
    }

    @FXML
    public void BaristaInterface(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("baristaInterface.fxml"));
        Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 503, 344);
        stage_new.setTitle("Barista Main");
        stage_new.setScene(scene_new);
        stage_new.show();
    }
    @FXML
    public void ManagerInterface(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("manager_interface.fxml"));
        Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 503, 344);
        stage_new.setTitle("Manager Main");
        stage_new.setScene(scene_new);
        stage_new.show();
    }
}
