package com.example.EEmployee.repository;

import com.example.EEmployee.collection.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Employee findByEmail(String email);
}
