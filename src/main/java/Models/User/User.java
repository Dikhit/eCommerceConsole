package Models.User;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private int walletPrice;
    private String password;
    private String role;
	private String date;

    public User(){

    }

    public User(String name, String email, int walletPrice, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.walletPrice = walletPrice;
        this.password = password;
        this.role = "CUSTOMER";
    }

    public User(String id, String name, String email, int walletPrice, String password, String role, String date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.walletPrice = walletPrice;
        this.password = password;
        this.role = role;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWalletPrice() {
        return walletPrice;
    }

    public void setWalletPrice(int walletPrice) {
        this.walletPrice = walletPrice;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", walletPrice=" + walletPrice + ", password="
				+ password + ", role=" + role + "]";
	}

    
}

