package com.example.invoice;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(InvoiceController.class);

    @PostMapping
    public Invoices createInvoice(@RequestBody Invoices invoice) {
        logger.info("Received request to create invoice: {}", invoice);
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping
    public List<Invoices> getAllInvoices() {
        logger.info("Received request to get all invoices");
        return invoiceService.getAllInvoices();
    }
    @GetMapping("/{id}")
    public Invoices getInvoiceById(@PathVariable Long id) {
        logger.info("Fetching invoice with ID: {}", id);
        return invoiceService.findById(id);
    }
    @PutMapping("/{id}")
    public Invoices updateInvoice(@PathVariable Long id, @RequestBody Invoices updatedInvoice) {
        logger.info("Updating invoice with ID {} in controller", id);
        return invoiceService.updateInvoice(id, updatedInvoice);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        logger.info("Deleting invoice with ID {} in controller", id);
        invoiceService.deleteInvoice(id);
    }
}
