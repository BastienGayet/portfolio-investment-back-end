package com.example.portfolio.repository;


import com.example.portfolio.models.TransactionModel;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionModel, Long> {
}
