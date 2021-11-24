package Models.Order;

import java.util.UUID;

public class Order {
    private String id;
    private String customerID;
    private String vendorID;
    private String productID;
    private int quantity;
    private int totalPrice;
    private String date;
    private boolean isAccepted;

	public Order(String id, String customerID, String productID, int quantity,  int totalPrice, boolean isAccepted, String vendorID, String date) {
        this.id = id;
        this.customerID = customerID;
        this.productID = productID;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.isAccepted = isAccepted;
        this.vendorID = vendorID;
    }

	public Order(String customerID, String productID, int quantity, int totalPrice) {
        this.id = UUID.randomUUID().toString();
        this.customerID = customerID;
        this.productID = productID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    public int getQuantity() {
        return quantity;
    }

	public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	public String getVendorID() {
		return vendorID;
	}

	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerID='" + customerID + '\'' +
                ", productID='" + productID + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", date='" + date + '\'' +
                '}';
    }
}
