package ie.conor.ecommerce.view;

import ie.conor.ecommerce.item.Product;
import ie.conor.ecommerce.main.Launcher;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class UserController {
	@FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Integer> productPriceColumn = new TableColumn<>("Item#");
    @FXML
   int productTotalCount = 0; 		//Counts the amount of items in basket
   @FXML
   String productCaluclation = "";
   @FXML
    public ObservableList<Product> productIn;
    
    @FXML
    private Label productNameLabel;
    @FXML
    private Label productDescriptionLabel;
    @FXML
    private Label productPriceLabel;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label subCategoryLabel;
    @FXML
    private Label productBestBeforeDateLabel;
    @FXML
    private Label cartNumberLabel;
    @FXML
    private Label totalPriceLabel;
    // Reference to the main application.
    private Launcher mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
   
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the product table with the a column for Product name and the price.
        productNameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty()); //.getValue() gets productName and updates table
        productPriceColumn.setCellValueFactory(cellData ->cellData.getValue().productPriceProperty().asObject()); //.asObject gets an integer value
  
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Launcher mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        productTable.setItems(mainApp.getProductData());
    }

    /**
     * Called when the user clicks on the delete button.
     */


    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleDeleteProduct() {
        int selectedIndex = productTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            productTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a product in the table.");
            
            alert.showAndWait();
        }
    }
    
/*
    @FXML
    void handleAddToCart(ActionEvent event) {
    	if () {
    		AddToCart();
    	}
    
    	
    	else {
    		
    	}
    
    }	*/
    	
  
	private void  AddToCart(Product product)  {
		
        int selectedIndex = productTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	productTable.getItems();
            
            productTotalCount++;
            cartNumberLabel.setText("" + productTotalCount);
        }
           
         if(selectedIndex >= 0) {
	            	productTable.getItems();
	            	
	            	productCaluclation = Integer.toString(product.getProductPrice());
	            	
	            	totalPriceLabel.setText("" + productCaluclation);

        } 
        else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a product in the table.");
            
            alert.showAndWait();
        }
    }
	
}