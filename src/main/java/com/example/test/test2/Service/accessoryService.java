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
        List<Ability> abil = abilityRepository.findAll();

        return abil;
    }

}
