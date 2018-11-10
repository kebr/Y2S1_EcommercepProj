package ch.makery.address.view;

import java.util.ArrayList;
import java.util.List;
import ch.makery.address.model.Product;

public class ShoppingCart {

	  private final List<Product> items;

	  public ShoppingCart() {
	    items = new ArrayList<Product>();
	  }

	  public void addItem(Product item) {

	    items.add(item);
	  }

	  public double calcTotalCost() {

	    double total = 0.0;
	    for (Product item : items) {

	total += item.getProductPrice();
	    }

	    return total;
	  }

	 
	}
