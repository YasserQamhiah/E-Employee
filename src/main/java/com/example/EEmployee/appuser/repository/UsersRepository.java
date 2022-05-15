package com.example.EEmployee.appuser.repository;

import com.example.EEmployee.appuser.collection.AppUser;
import com.example.EEmployee.collection.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UsersRepository extends MongoRepository<AppUser,String> {
    Optional<AppUser> findByEmail(String email);
}
