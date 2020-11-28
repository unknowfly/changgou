package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Brand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int delete(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }
}
