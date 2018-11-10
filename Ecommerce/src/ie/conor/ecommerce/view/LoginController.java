package ie.conor.ecommerce.view;

import ie.conor.ecommerce.item.Product;
import ie.conor.ecommerce.main.Launcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.Button;


public class LoginController {
	private Launcher mainApp;
	  private Stage primaryStage;
	    private BorderPane rootLayout;
	    
	    /**
	     * The data as an observable list of Persons.
	     */
	    private ObservableList<Product> productData = FXCollections.observableArrayList();

	    /**
	     * Constructor
	     */
	    public LoginController() {
	        // Add some sample data
	        productData.add(new Product("Apple", 15));
	        productData.add(new Product("Banana" ,20));
	        productData.add(new Product("Orange", 350));
	        productData.add(new Product("Cucumber", 5));
	       
	           }
	    
	    
	    
	    @FXML
		private Label lblStatus;

		@FXML
		private TextField txtUserName;

		@FXML
		private TextField txtPassword;
		
		@FXML
		private Button ExitButton;
	    @FXML
	    private TextField txtFname;
	    @FXML
	    private TextField txtLname;
	    @FXML
	    private Label txtFeedback;
		
		
		  public void Login(ActionEvent event) throws Exception {
				
		    	//check if the user has put in the correct admin username and password
		    	if (userLoginCheck(txtUserName, txtPassword)) {
					/*txtFeedback.setText("Admin Login Success");
					Stage dialogStage = new Stage();	
					Parent root = FXMLLoader.load(getClass().getResource("view/PersonOverview.fxml"));
					Scene scene = new Scene(root,1000,500);
					dialogStage.setScene(scene);
					dialogStage.show();*/
					
					}	
		    	
		    	//if the user doesnt match the admin username and password
		    	//try to match with the customer username and password
		    	
					else if (userLoginCheck(txtUserName, txtPassword)) {
						txtFeedback.setText("User Login Success");
						Stage dialogStage = new Stage();	
						Parent root = FXMLLoader.load(getClass().getResource("/UserOverviewController.fxml"));
						Scene scene = new Scene(root,1000,500);
						dialogStage.setScene(scene);
						dialogStage.show();
					
					} 
		    			//else they will get a pop up saying incorrect username and password
						else {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Incorect Username & Password");
							alert.setHeaderText("Incorect Username & Password");
							alert.setContentText("Please enter a different Username & Password");
							alert.showAndWait();
							}
					}
		  
		  private boolean userLoginCheck(TextField txtUsername, TextField txtPassword){
	    		if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")) {
	    			System.out.println("Login SUCCESS for admin");
	    			lblStatus.setText("login SUCCESS");
	    			
	    			
	    			
	    			
	    			return true;
	    		}else if(txtUsername.getText().equals("user") && txtPassword.getText().equals("user")) {
	    			System.out.println("Login SUCCESS for user");
	    			lblStatus.setText("login SUCCESS");
	    			return true;
	    		} { 
	    			System.out.println("Login FAILED for user"); 
	    			lblStatus.setText("login FAILED");
	    		return false;	
	    		}
	    		}


	    		/**
	    		 	*userLoginCheck checks if the required username and password is given  
	    		 	*if the details are valid the user will be brought to the customer screen
	    		 */
	    	
	    		 public void setMainApp(Launcher mainApp) {
	    		        this.mainApp = mainApp;

	    		        // Add observable list data to the table
	    		       // productTable.setItems(mainApp.getProductData());
	    		    }


	    		}