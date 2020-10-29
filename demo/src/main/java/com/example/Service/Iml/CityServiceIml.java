package com.example.Service.Iml;

import com.example.Model.City;
import com.example.Service.CityService;
import com.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public class CityServiceIml implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public Page<City> findAll(Pageable pageInfo) {
        return cityRepository.findAll(pageInfo);
    }

    @Override
    public Page<City> findAll() {
        return (Page<City>) cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
      cityRepository.deleteById(id);
    }
}
