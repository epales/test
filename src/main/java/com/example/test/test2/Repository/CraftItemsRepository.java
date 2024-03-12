package com.example.test.test2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.test2.Domain.CraftItems;
import java.util.List;

public interface CraftItemsRepository extends JpaRepository<CraftItems, Integer> {

    List<CraftItems> findAllByCraftCode(int craftCode);

}
