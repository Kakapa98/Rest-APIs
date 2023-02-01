package com.bank.kahuna.api.APIs_project.services;

import com.bank.kahuna.api.APIs_project.models.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerServices {

    private static List<Customer> customersList = new ArrayList<Customer>();


    static {
        customersList.add(new Customer(1, "Peter Adams", "QwaQwa"));
        customersList.add(new Customer(2, "John Smith", "Johannesburg"));
        customersList.add(new Customer(3, "Robert Mark", "George"));
    }


    //Get the customers
    public List<Customer> getAllCustomers(){
        return customersList;
    }

    //Get single customer
    public Customer getCustomerById(int id){
        return customersList.stream().filter(c -> c.getId() == (id)).findFirst().get();
    }

    //Create customer
    public String AddCustomer(Customer customer){
        CustomerServices.customersList.add(customer);
        return "Customer added";
    }

    //Update customer
    public String UpdateCustomer(Customer customer, int id){
        customersList.stream().map(c -> {
            if (c.getId() == (id)){
                c.setName(c.getName());
                c.setAddress(c.getAddress());
            }
            return c;
        }).collect(Collectors.toList());
        return "Customer updated";
    }

    //Delete a Customer
    public String deleteCustomer(int id) {
        customersList = customersList.stream().filter(c -> c.getId() == id).collect(Collectors.toList());
        return "Customer deleted";
    }
}
