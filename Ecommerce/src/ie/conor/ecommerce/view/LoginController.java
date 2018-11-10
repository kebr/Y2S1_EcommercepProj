package ie.conor.ecommerce.view;

import java.io.IOException;



import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;



/**

 * 

 * @author joedaly

 * @date October 2018

 *

 */

public class LoginController {

@FXML

private TextField userName;

@FXML

private TextField password;

@FXML

private Label message;

Stage dialogStage = new Stage();  //Because dialogStage and scene are instance variables of the class,

    Scene scene;                               // they are available to all methods without being passed to them.

                                                         // They exist while the LoginController object exists

    

    /**

* handleLoginBtn responds to the login button being pressed on the login scene

* call checkLogin to check if the login details are correct.

* if correct:

* identifies the Source for the event (login scene)

* identifies the Stage(window) in which the Source eminated.

* closes that Stage

* opens the menu scene and sets it to the dialogStage

* if incorrect:

* displays a message "Invalid"

* 

* @param e  ActionEvent - back button pressed event

*/

public void handleLoginBtn(ActionEvent e){

if(checkLogin(userName,	password)){  //checkLogin returns true if userName and password are correct

message.setText("");

            Node node = (Node)e.getSource();

            dialogStage = (Stage) node.getScene().getWindow();

            dialogStage.close();

            try {

scene = new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml")));

} catch (IOException e1) {

// TODO Auto-generated catch block

e1.printStackTrace();

}

            dialogStage.setScene(scene);

            dialogStage.show();

}

else{

message.setText("Invalid");

}

}

/**

* handleBackBtn responds to the back button being pressed on the simple menu scene

* identifies the Source for the event (menu scene)

* identifies the Stage(window) in which the Source eminated.

* closes that Stage

* opens the Login scene and sets it to the dialogStage

* 

* @param e  ActionEvent - back button pressed event

*/

public void handleBackBtn(ActionEvent e){

            Node node = (Node)e.getSource();

            dialogStage = (Stage) node.getScene().getWindow();

            dialogStage.close();

            try {

scene = new Scene(FXMLLoader.load(getClass().getResource("/Ecommerce/src/ie/conor/ecommerce/view/Login.fxml")));

} catch (IOException e1) {

// TODO Auto-generated catch block

e1.printStackTrace();

}

            dialogStage.setScene(scene);

            dialogStage.show();

}

/**

*checkLogin checks that the userName and password are valid

*

* @param username - username entered by the user on the Login scene

* @param password - password entered by the user on the Login scene

* @return true if valid password, otherwise false

*/

private boolean checkLogin(TextField username,	TextField password){

//very simplistic static username/password check implemented here

//usernames and passwords should be stored and searched for a match.

//typically passwords would be encrypted in the stored file

if(username.getText().equals("Joe") && password.getText().equals("1234"))

return true;

return false;



}

}

