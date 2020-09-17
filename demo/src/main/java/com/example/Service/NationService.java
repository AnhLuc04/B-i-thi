package com.example.Service;

import com.example.Model.Nation;

import java.util.List;
import java.util.Optional;

public interface NationService {
    List<Nation> findAll();

//    Province findOne(Long id);

    Optional<Nation> findById(Long id);

    Nation save(Nation nation);

    void remove(Long id);

}
