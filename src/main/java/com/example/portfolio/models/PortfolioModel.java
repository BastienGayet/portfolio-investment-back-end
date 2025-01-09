package com.example.portfolio.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data

public class PortfolioModel {
    @Id
    private String _id;
    private String userId;
    private String name;
    private String createdAt;
    private List<Holding[]> holdings;

}
