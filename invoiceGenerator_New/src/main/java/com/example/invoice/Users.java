package com.example.invoice;


import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  userId;
    @NotBlank(message = "Please specify Username")
    @Column(unique = true)
    private String userName;
    @NotBlank(message = "Password Required")
    private String password;
    @NotBlank(message = "Please Enter your EmailID")
    private String email;
    private LocalDate signInDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Invoices> invoices;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getSignInDate() {
		return signInDate;
	}

	public void setSignInDate(LocalDate signInDate) {
		this.signInDate = signInDate;
	}

	public List<Invoices> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoices> invoices) {
		this.invoices = invoices;
	}

 

	   
    
}
