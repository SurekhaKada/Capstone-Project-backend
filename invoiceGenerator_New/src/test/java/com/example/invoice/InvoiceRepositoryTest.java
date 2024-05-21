package com.example.invoice;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.InvoiceNotFoundException;

//import jakarta.transaction.Transactional;

@Transactional
@SpringBootTest
class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;
   
    @Autowired
    public void InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
   
//    @BeforeEach
//    void setUp() {
//        invoiceService = new InvoiceService();
//    }

    @Test
    void testCreateInvoice() {
        Invoices invoice = new Invoices();
        invoice.setClientName("Test Client");
        LocalDate specificDate = LocalDate.of(2024, 5, 20);
         invoice.setDate(specificDate);
        invoice.setAmount(100.0);
        
        Invoices createdInvoice = invoiceRepository.save(invoice);
        
        assertNotNull(createdInvoice);
        assertNotNull(createdInvoice.getInvoiceId());
        assertEquals("Test Client", createdInvoice.getClientName());
        LocalDate assertdate = LocalDate.of(2024, 5, 20);
        assertEquals(assertdate, createdInvoice.getDate());
        assertEquals(100.0, createdInvoice.getAmount());
    }

//    @Test
//    void testGetAllInvoices() {
//        Invoices invoice1 = new Invoices();
//        invoice1.setClientName("Test Client 1");
//       // invoice1.setDate("2024-05-20");
//        invoice1.setAmount(100.0);
//        
//        Invoices invoice2 = new Invoices();
//        invoice2.setClientName("Test Client 2");
//       // invoice2.setDate("2024-05-21");
//        invoice2.setAmount(200.0);
//        
//        invoiceService.createInvoice(invoice1);
//        invoiceService.createInvoice(invoice2);
//        
//        List<Invoices> invoices = invoiceService.getAllInvoices();
//        
//        assertNotNull(invoices);
//        assertEquals(2, invoices.size());
//    }
//
//    @Test
//    void testFindById() {
//        Invoices invoice = new Invoices();
//        invoice.setClientName("Test Client");
//        //invoice.setDate("2024-05-20");
//        invoice.setAmount(100.0);
//        
//        Invoices createdInvoice = invoiceRepository.save(invoice);
//        
//       Long id = (long) createdInvoice.getInvoiceId();
//        
//        Optional<Invoices> foundInvoice = invoiceRepository.findById(id);
//        
//        assertNotNull(foundInvoice);
//        assertEquals("Test Client", foundInvoice.getClientName());
//        assertEquals("2024-05-20", foundInvoice.getDate());
//        assertEquals(100.0, foundInvoice.getAmount());
//    }
////
    @Test
    public void deleteInvoiceTest() {
       
        Invoices invoice = new Invoices();
        invoiceRepository.save(invoice);
        invoiceRepository.delete(invoice);
        Optional<Invoices> deletedInvoice = invoiceRepository.findById((long) invoice.getInvoiceId());
        assertFalse(deletedInvoice.isPresent());
    }

    
    @Test
    public void findNonExistentInvoiceByIdTest() {
        // Find a user with a non-existent ID
        Optional<Invoices> foundUser = invoiceRepository.findById(-1L);
        
        assertFalse(foundUser.isPresent());
    }
    @Test
    public void saveNullInvoice() {
        try {
            invoiceRepository.save(null);
        } catch (Exception e) {
            // Expected Exception occurred, test passed
            return;
        }
        fail("Expected IllegalArgumentException was not thrown");
    }
}