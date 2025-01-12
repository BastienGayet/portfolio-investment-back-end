package com.example.portfolio.repository;

import com.example.portfolio.models.UsersModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsersRepository extends MongoRepository<UsersModel, String> {

    UsersModel findByEmail(String email);

}
