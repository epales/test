package com.example.test.test2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.test2.Domain.CraftMake;

public interface CraftMakeRepository extends JpaRepository<CraftMake, Integer> {

    List<CraftMake> findAllByCode(int code);
}
