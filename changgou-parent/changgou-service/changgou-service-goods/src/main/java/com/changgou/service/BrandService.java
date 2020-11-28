package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandService {

    List<Brand> findAll();

    Brand findById(Integer id);

    int add(Brand brand);

    int update(Brand brand);

    int delete(Integer id);
}
