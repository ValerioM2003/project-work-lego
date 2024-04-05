package com.example.generationlego.service;

import com.example.generationlego.dao.BrandDao;
import com.example.generationlego.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandDao brandDao;
    @Override
    public void registraBrand(Brand brand) {
        brandDao.save(brand);

    }

    @Override
    public List<Brand> getBrand() {
        return (List<Brand>) brandDao.findAll();
    }

    @Override
    public Brand getBrandById(int id) {
        return brandDao.findById(id).get();
    }

    @Override
    public void cancellaBrand(int id) {
        brandDao.deleteById(id);

    }
}
