package com.example.Service;

import com.example.Model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface CityService {
    Page<City> findAll(Pageable pageInfo);
    Page<City> findAll();
    Optional<City> findById(Long id);
    City save(City city);
    void delete(Long id);
}
