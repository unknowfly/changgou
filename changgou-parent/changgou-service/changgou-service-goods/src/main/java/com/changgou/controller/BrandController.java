package com.changgou.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin()
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK, "ok", brandList);
    }

    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id){
        return new Result<Brand>(true, StatusCode.OK, "ok", brandService.findById(id)) ;
    }

    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result<>(true, StatusCode.OK, "ok");
    }

    @PutMapping("/{id}")
    public Result<Integer> update(@PathVariable("id") Integer id, @RequestBody Brand brand){
        brand.setId(id);
        int rows = brandService.update(brand);
        return new Result<Integer>(true, StatusCode.OK, "ok", rows);
    }

    @DeleteMapping("/{id}")
    public Result<Integer> delete(@PathVariable("id") Integer id){
        return new Result<Integer>(true, StatusCode.OK, "ok", brandService.delete(id)) ;
    }
}
