package com.example.EEmployee.appuser.repository;

import com.example.EEmployee.collection.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UsersRepository {
    Optional<Employee> findByEmail();
}
