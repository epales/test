package com.example.test.test2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.test2.Domain.Ability;

public interface AbilityRepository extends JpaRepository<Ability, Integer> {

}
