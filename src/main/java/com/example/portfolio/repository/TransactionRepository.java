package com.example.portfolio.repository;


import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<PulsarProperties.Transaction, Long> {
}
