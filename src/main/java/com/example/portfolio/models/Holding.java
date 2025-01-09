package com.example.portfolio.models;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Holding {

    private String assetId;
    private int quantity;
    private double averagePrice;
    private LocalDateTime lastUpdated;
}
