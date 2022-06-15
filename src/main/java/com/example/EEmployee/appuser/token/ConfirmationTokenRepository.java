package com.example.EEmployee.appuser.token;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends MongoRepository<ConfirmationToken,Long> {


    @Query("{token : ?0}")
    Optional<ConfirmationToken> findByToken(String token);
}
