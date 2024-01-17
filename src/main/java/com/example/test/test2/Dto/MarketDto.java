package com.example.test.test2.Dto;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class MarketDto {
    private String name;
    
    private String grade;
    
    private String imgSrc;
    
    @Id
    private int    code;
    
    private int    currentMinPrice;
    
    private Date   updateTime;

    
}