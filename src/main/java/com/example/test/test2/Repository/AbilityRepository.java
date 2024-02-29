package com.example.test.test2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.test2.Domain.Ability;

public interface AbilityRepository extends JpaRepository<Ability, String> {

    List<Ability> findByJobsNot(String jobs);
}
