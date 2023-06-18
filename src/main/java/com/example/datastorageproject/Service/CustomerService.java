package com.example.datastorageproject.Service;

import com.example.datastorageproject.DTO.CustomerCarInfoDTO;
import com.example.datastorageproject.Model.Customer;
import com.example.datastorageproject.Model.User;
import com.example.datastorageproject.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public List<CustomerCarInfoDTO> getCustomerDTO(){
        return customerRepository.getCustomerCarInfo()
                .stream()
                .map(arr -> new CustomerCarInfoDTO(
                        Integer.parseInt(String.valueOf(arr[0])),
                        (String) arr[1],
                        (String) arr[2],
                        (String) arr[3],
                        (String) arr[4],
                        (String) arr[5],
                        (String) arr[6],
                        (String) arr[7]))
                .collect(Collectors.toList());
    }

    public void deleteCustomerById(Integer id){
        customerRepository.deleteById(id);
    }
}
