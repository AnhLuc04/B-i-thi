package com.example.repository;

import com.example.Model.City;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CityRepository extends PagingAndSortingRepository<City, Long> {
}
