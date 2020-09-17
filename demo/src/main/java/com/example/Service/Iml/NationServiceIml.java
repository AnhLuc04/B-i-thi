package com.example.Service.Iml;

import com.example.Model.Nation;
import com.example.Service.NationService;
import com.example.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class NationServiceIml implements NationService {
    @Autowired
    NationRepository nationRepository;
    @Override
    public List<Nation> findAll() {
        return (List<Nation>) nationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return nationRepository.findById(id);
    }

    @Override
    public Nation save(Nation nation) {
        return nationRepository.save(nation);
    }

    @Override
    public void remove(Long id) {
    nationRepository.deleteById(id);
    }
}
