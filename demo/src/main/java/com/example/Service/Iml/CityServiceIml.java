package com.example.Service.Iml;

import com.example.Model.City;
import com.example.Service.CityService;
import com.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class CityServiceIml implements CityService {
    @Autowired
    CityRepository cityRepository;
    @Override
    public Iterable<City> findAll() {
        return null;
    }

    @Override
    public Page<City> findAll(Pageable pageInfo) {
        return cityRepository.findAll(pageInfo);
    }

    @Override
    public List<City> search(String keyword) {
        return null;
    }

    @Override
    public Page<City> search(String keyword, Pageable pageInfo) {
        return null;
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
    public List<City> save(List<City> city) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<City> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {
      cityRepository.deleteById(id);
    }



    @Override
    public void delete(List<City> city) {

    }

    @Override
    public void deleteAll() {

    }
}
