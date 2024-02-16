package com.example.test.test2.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.test2.Domain.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

    Optional<Items> findByName(String id);

    List<Items> findBycode(int code);
}
