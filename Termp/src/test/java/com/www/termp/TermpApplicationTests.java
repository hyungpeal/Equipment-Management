package com.www.termp;

import com.www.termp.entity.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.www.termp.repository.CustomerRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TermpApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void contextLoads() {

        Customer customer = Customer.builder()
                .customerName("Customer Name")
                .customerPhone("Customer Phone")
                .build();

        Customer savedCustomer = customerRepository.save(customer);
        
        assertThat(savedCustomer).isEqualTo(customer);
    }

    @AfterEach
    public void tearDown() {
        customerRepository.deleteAll();
    }

}
