package ie.conor.ecommerce.view;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.Button;
import java.io.IOException;

import ie.conor.ecommerce.item.Product;


public class LoginController {
	
	  private Stage primaryStage;
	    private BorderPane rootLayout;
	    
	    /**
	     * The data as an observable list of Products
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
		    	if (adminLoginCheck(txtUserName, txtPassword)) {
					txtFeedback.setText("Admin Login Success");
					Stage dialogStage = new Stage();	
					Parent root = FXMLLoader.load(getClass().getResource("view/PersonOverview.fxml"));
					Scene scene = new Scene(root,1000,500);
					dialogStage.setScene(scene);
					dialogStage.show();
					
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
		  
		  private boolean adminLoginCheck(TextField txtUsername, TextField txtPassword){
	    		if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("pass"))
	    			return true;
	    		return false;
	    		}


	    		/**
	    		 	*userLoginCheck checks if the required username and password is given  
	    		 	*if the details are valid the user will be brought to the customer screen
	    		 */
	    		private boolean userLoginCheck(TextField txtUsername, TextField txtPassword){
	    			if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass"))
	    				return true;
	    			return false;
	    			}
		

		  

		
		
		

	    /**
	     * Returns the data as an observable list of Persons. 
	     * @return
	     */
	    public ObservableList<Product> getProductData() {
	        return productData;
	    }

	    public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("AddressApp");

	        initRootLayout();

	        showPersonOverview();
	    }

	    /**
	     * Initializes the root layout.
	     */
	    public void initRootLayout() {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(LoginController.class.getResource("view/RootLayout.fxml"));
	            rootLayout = (BorderPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Shows the person overview inside the root layout.
	     */
	    public void showPersonOverview() {
	        try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(LoginController.class.getResource("view/PersonOverview.fxml"));
	            AnchorPane personOverview = (AnchorPane) loader.load();

	            // Set person overview into the center of root layout.
	            rootLayout.setCenter(personOverview);

	            // Give the controller access to the main app.
	            PersonOverviewController controller = loader.getController();
	            controller.setMainController(this);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * Opens a dialog to edit details for the specified person. If the user
	     * clicks OK, the changes are saved into the provided person object and true
	     * is returned.
	     * 
	     * @param person the person object to be edited
	     * @return true if the user clicked OK, false otherwise.
	     */
	    public boolean showPersonEditDialog(Product product) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(LoginController.class.getResource("view/PersonEditDialog.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Edit Person");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            PersonEditDialogController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setPerson(product);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    /**
	     * Returns the main stage.
	     * @return
	     */
	    public Stage getPrimaryStage() {
	        return primaryStage;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }




		private static void launch(String[] args) {
			// TODO Auto-generated method stub
			
		}

	
}