package com.example.portfolio.models;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class PriceAlerts {

    @Id
    private String priceAlertId;

    private String assetName;
    private int targetPrice;
    private  boolean IsUpperLimite;
    private String createdAt;
    private  boolean IsTriggered;


}
