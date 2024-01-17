package com.example.test.test2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.test2.Dto.MarketDto;

public interface MarketRepository extends JpaRepository<MarketDto,Integer> {
    MarketDto findByCode(int code);   
    
}
