package com.example.generationlego.dao;

import com.example.generationlego.model.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandDao extends CrudRepository<Brand, Integer> {
}
