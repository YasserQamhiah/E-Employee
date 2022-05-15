package com.example.EEmployee.repository;

import com.example.EEmployee.collection.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Employee findByEmail(String email);
}
