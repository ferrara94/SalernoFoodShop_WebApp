package com.develop.webapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.webapp.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{

}
