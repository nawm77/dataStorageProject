package com.example.datastorageproject.Service;

import com.example.datastorageproject.Model.Customer;
import com.example.datastorageproject.Model.User;
import com.example.datastorageproject.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user){
         Customer customer = new Customer();
         customer.setPassword(passwordEncoder.encode(user.getPassword()));
         customer.setRole(user.getRole());
         customer.setStatus(user.getStatus());
         customer.setUsername(user.getUsername());
         customer.setName(user.getName());
         customer.setEmail(user.getEmail());
         customer.setLastname(user.getLastname());
         customer.setPhoneNumber(user.getPhoneNumber());
         customerRepository.save(customer);
    }
}
