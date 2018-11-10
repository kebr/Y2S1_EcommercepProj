package ie.conor.ecommerce.view;

import ie.conor.ecommerce.date.DateUtil;
import ie.conor.ecommerce.item.Product;
import ie.conor.ecommerce.main.Launcher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class AdminController {
	@FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> productNameColumn;
 

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
        // Initialize the person table with the two columns.
        productNameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        
  
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
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
    
    private void showProductDetails(Product product) {
    	
        if (product != null) {
            // Fill the labels with info from the product object.
            productNameLabel.setText(product.getProductName());
            productDescriptionLabel.setText(product.getDescription());
            categoryLabel.setText(product.getCategory());
            productPriceLabel.setText(Integer.toString(product.getProductPrice()));
            subCategoryLabel.setText(product.getSubCategory());
            productBestBeforeDateLabel.setText(DateUtil.format(product.getBestBeforeDate()));
            
        } else {
            // Person is null, remove all the text.
        	 productNameLabel.setText("");
        	 productDescriptionLabel.setText("");
        	 categoryLabel.setText("");
        	 productPriceLabel.setText("");
        	 subCategoryLabel.setText("");
        	 productBestBeforeDateLabel.setText("");
        	  
        }
        
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteProduct() {
        int selectedIndex = productTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            productTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp .getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    
    /*
    @FXML
    private void handleNewPerson() {
        Product tempProduct = new Product();
        boolean okClicked = mainApp.showEditProduct(tempProduct);
        if (okClicked) {
        	mainApp.getProductData().add(tempProduct);
        }
    }
    
    */

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            boolean okClicked = mainApp.showEditProduct(selectedProduct);
            if (okClicked) {
                showProductDetails(selectedProduct);
            }

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

	public void setAdminController(AdminController admincontroller) {
		// TODO Auto-generated method stub
		
	}

}