package com.example.test.test2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.test2.Domain.Ability;
import com.example.test.test2.Repository.AbilityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class accessoryService {

    private final AbilityRepository abilityRepository;

    public List<Ability> getDatabase() {

        List<Ability> abil = abilityRepository.findByJobsNot("패널티");

        return abil;
    }

    public List<Ability> getDatabaseByName(String name) {

        List<Ability> abil = abilityRepository.findByNameContains(name);

        return abil;
    }

    public List<Ability> getAllDatabaseByJobs() {

        List<Ability> abil = abilityRepository.findByJobs("공용");

        return abil;
    }

    public List<Ability> getDatabaseByJobs(String name) {

        List<Ability> abil = abilityRepository.findByJobsAndNameContains("공용", name);

        return abil;
    }
}
