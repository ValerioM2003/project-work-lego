package com.example.generationlego.service;

import com.example.generationlego.model.Brand;

import java.util.List;

public interface BrandService {
    void registraBrand(Brand brand);
    List<Brand> getBrand();
    Brand getBrandById(int id);
    void cancellaBrand(int id);
}
