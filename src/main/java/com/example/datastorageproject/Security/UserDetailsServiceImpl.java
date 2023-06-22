package com.example.datastorageproject.Security;

import com.example.datastorageproject.Model.User;
import com.example.datastorageproject.Repository.CustomerRepository;
import com.example.datastorageproject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public UserDetailsServiceImpl(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        if(customerRepository.existsByEmail(email)){
            user = customerRepository.findByEmail(email).stream().findAny().orElseThrow(()->
                    new UsernameNotFoundException("User doesn't exist"));
        } else if(employeeRepository.existsByEmail(email)){
            user = employeeRepository.findByEmail(email).stream().findFirst().orElseThrow(() ->
                    new UsernameNotFoundException("User doesn't exist"));
        }
        return SecurityUser.fromUser(user);
    }
}