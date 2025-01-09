package com.example.portfolio.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data

public class TransactionModel {

    @Id
    private String id;               // Identifiant unique de la transaction
    private String portfolioId;      // Référence au portfolio concerné
    private String assetId;          // Référence à l'actif concerné
    private double quantity;         // Quantité achetée/vendue
    private double price;            // Prix unitaire
    private TransactionType type;    // Type de transaction (ACHAT ou VENTE)
    private LocalDateTime transactionDate; // Date de la transaction
    private LocalDateTime createdAt; // Date d'enregistrement

    // Enum pour le type de transaction
    public enum TransactionType {
        BUY,
        SELL
    }

    // Constructeurs, getters, setters, etc.
}

