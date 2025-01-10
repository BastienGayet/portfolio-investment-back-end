package com.example.portfolio.models;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
public class UsersModel {

    @Id
    private String id;


    private String name;
    private String email;
    private String hashedPassword;
    private List<PortfolioModel[] > portfolios = new ArrayList<>();
    private List<PriceAlertsModel> priceAlertModels = new ArrayList<>();
}



