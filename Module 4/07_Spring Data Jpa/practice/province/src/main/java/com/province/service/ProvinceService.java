package com.province.service;

import com.province.entity.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findById(Integer id);

    void save(Province province);

    void remove(Integer id);
}