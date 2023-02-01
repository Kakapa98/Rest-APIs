package com.bank.kahuna.api.APIs_project.controllers;

import com.bank.kahuna.api.APIs_project.models.Customer;
import com.bank.kahuna.api.APIs_project.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankCustomer {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers(){
        return customerServices.getAllCustomers();
    }

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return customerServices.getCustomerById(id);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody final Customer customer){
        return customerServices.AddCustomer(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    public String updateCustomer(@RequestBody final Customer customer, @PathVariable("id") int id){
        return customerServices.UpdateCustomer(customer, id);
    }

    @DeleteMapping("/removeCustomer/{id}")
    public String removeCustomer(@PathVariable("id") int id){
        return customerServices.deleteCustomer(id);
    }
}
