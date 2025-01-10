package com.example.portfolio.repository;


import com.example.portfolio.models.PriceAlertsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceAlertsRepository  extends MongoRepository<PriceAlertsModel, String> {
}
