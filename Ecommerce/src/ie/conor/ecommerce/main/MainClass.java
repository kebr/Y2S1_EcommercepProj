package ie.conor.ecommerce.main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.stage.Stage;

import javafx.scene.Parent;

import javafx.scene.Scene;





public class MainClass extends Application {

@Override

public void start(Stage primaryStage) {

try {

Parent root = FXMLLoader.load(getClass().getResource("/Ecommerce/src/ie/conor/ecommerce/view/Login.fxml"));

Scene scene = new Scene(root,400,400);

scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

primaryStage.setScene(scene);

primaryStage.show();

} catch(Exception e) {

e.printStackTrace();

}

}

public static void main(String[] args) {

launch(args);

}

}