package com.example.portfolio.repository;

import com.example.portfolio.models.PortfolioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository  extends MongoRepository<PortfolioModel, String> {
}
