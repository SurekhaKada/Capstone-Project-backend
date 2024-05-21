package com.example.invoice;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.exception.ValidationException;


public class InvoiceTest {

    @Test
     void testCreateInvoice() {
       
        Invoices invoice = new Invoices();
        invoice.setInvoiceId(5);
        invoice.setAmount(100.00);
        invoice.setClientName("John Doe");

       
        assertEquals(5L, invoice.getInvoiceId());
        assertEquals(100.00, invoice.getAmount());
        assertEquals("John Doe", invoice.getClientName());
        }

    @Test
    public void testInvoiceValidation() {
        // Create an invoice with invalid data
        Invoices invoice = new Invoices();
        invoice.setInvoiceId( 0); // Empty invoice number
        invoice.setAmount(-50.00); // Negative amount
        invoice.setClientName(null); // Null customer name
      
        // Validate the invoice
        assertThrows(ValidationException.class, () -> {
            invoice.validate(); // Should throw a ValidationException
        });
    }
}

   

//class InvoiceTest {
//
//    @Test
//     void testGetters() {
//       
//        Invoices invoice = new Invoices();
//        assertEquals(1L, invoice.getId());
//        assertEquals("sankar", invoice.getClientName());
//        assertNotEquals(LocalDate.of(2024, 5, 20), invoice.getDate());
//        assertNotEquals(1000.0, invoice.getAmount());
//        
//    }
//
//    @Test
//     void testSetters() {
//        
//    	 Invoices invoice = new Invoices();
//
//        invoice.setId(1L);
//        invoice.setClientName("Client Name");
//        invoice.setDate(LocalDate.of(2022, 5, 15));
//        invoice.setAmount(9000);
//       
//
//        // Verify using getters
//        assertEquals(1L, invoice.getId());
//        assertEquals("Client Name", invoice.getClientName());
//        assertEquals(LocalDate.of(2022, 5, 15), invoice.getDate());
//        assertEquals(9000, invoice.getAmount());
//        
//    }
//
//    
//}
//
