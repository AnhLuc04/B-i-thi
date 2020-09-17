package com.example.Service;

import com.example.Model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CityService {
    Iterable<City> findAll();

    Page<City> findAll(Pageable pageInfo);

    List<City> search(String keyword);

    Page<City> search(String keyword, Pageable pageInfo);

//    Customer findOne(Long id);

    Optional<City> findById(Long id);

    City save(City city);

    List<City> save(List<City> city);

    boolean exists(Long id);

    List<City> findAll(List<Long> ids);

    long count();

    void delete(Long id);


    void delete(List<City> city);

    void deleteAll();
}
