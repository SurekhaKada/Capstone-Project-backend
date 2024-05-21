package com.example.invoice;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.InvoiceNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
//    @Autowired
////    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    public Invoices createInvoice(Invoices invoice) {
        logger.info("Creating invoice: {}", invoice);
        return invoiceRepository.save(invoice);
    }



    public List<Invoices> getAllInvoices() {
        logger.info("Fetching all invoices");
        return invoiceRepository.findAll();
    }
//    public Invoices findById(Long id) {
//    	return invoiceRepository.findById(id)
//                .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found with ID: " +id));
//    }
    public Invoices findById(Long id) {
        Optional<Invoices> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isPresent()) { // Check if the optional contains a value
            return optionalInvoice.get(); // Retrieve the value from optional
        } else {
            throw new InvoiceNotFoundException("Invoice not found with ID: " + id);
        }
    }

   

    public void deleteInvoice(Long id) {
        logger.info("Deleting invoice with ID {}", id);
        invoiceRepository.deleteById(id);
    }
 
    public Invoices updateInvoice(Long id, Invoices updatedInvoice) {
        logger.info("Updating invoice with ID {} in service", id);
        Invoices existingInvoice = invoiceRepository.findById(id).orElse(null);
        if (existingInvoice != null) {
            existingInvoice.setClientName(updatedInvoice.getClientName());
           existingInvoice.setDate(updatedInvoice.getDate());
            existingInvoice.setAmount(updatedInvoice.getAmount());
            //existingInvoice.setUser(updatedInvoice.getUser());
            return invoiceRepository.save(existingInvoice);
        } else {
            logger.warn("Invoice with ID {} not found", id);
            return null;
        }
    }

 
}
