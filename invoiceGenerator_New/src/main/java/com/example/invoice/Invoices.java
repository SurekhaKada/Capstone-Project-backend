package com.example.invoice;


import java.time.LocalDate;

import com.example.exception.ValidationException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Invoices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceId;
    
    @NotBlank(message = "Please specify client name")
    private String clientName;
    
    @Min(value = 3000,message = "Amount should be greater than 3000")
    private double amount;
    private LocalDate date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId" ,referencedColumnName = "userId")
    private Users user;
    
    



    

	public int getInvoiceId() {
		return invoiceId;
	}




	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}




	public String getClientName() {
		return clientName;
	}




	public void setClientName(String clientName) {
		this.clientName = clientName;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public LocalDate getDate() {
		return date;
	}




	public void setDate(LocalDate date) {
		this.date = date;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription (String description) {
		this.description = description;
	}

	




	public void validate() {
        if (invoiceId==0) {
            throw new ValidationException("Invoice number cannot be empty");
        }
        if (amount <= 0) {
            throw new ValidationException("Invoice amount must be greater than zero");
        }
        if (clientName == null) {
            throw new ValidationException("Customer name cannot be null");
        }
       
        
    }


//	 public Users getUser() {
//	        return user;
//	    }
//
//	    public void setUser(User user) {
//	        this.user = user;
//	    }




	
}
