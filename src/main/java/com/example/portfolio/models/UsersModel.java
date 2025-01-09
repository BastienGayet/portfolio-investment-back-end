package com.example.portfolio.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Users")
public class UsersModel {

    @Id
    private String _id;


    private String name;
    private String email;
    private String hashedPassword;
    private List<PortfolioModel[] > portfolios;
    private List<PriceAlerts> priceAlerts;
}



