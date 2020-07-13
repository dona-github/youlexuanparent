package com.offcn.sellergoods.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import com.offcn.pojo.TbBrand;
import com.offcn.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    //远程服务调用需要dubbo的注解而不是之前用的spring或者jdk的注解
    @Reference
    BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {

        return brandService.findAll();
    }
    //把查询的数据分页显示
    @RequestMapping("/findPage")
    public PageResult findPage(int page,int rows) {
        return brandService.findPage(page,rows);
    }

    //新增 不需要返回数据 可以返回添加成功或者失败的提示
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand) {
       try {
           brandService.add(brand);
           return new Result(true,"增加成功");
       }catch (Exception e) {
           e.printStackTrace();
           return new Result(false,"增加失败");
       }
    }

    //修改:先根据id获取实体返回给前端 然后修改之后重新把实体传入后端返回修改成功与否的包装类
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }
    //需要前端传入修改后的实体类
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand) {
        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(false,"修改失败");
        }
    }

    //删除 注意按id批量删除 按id删除需要传递id值 没有返回值 可以返回删除成功或者失败
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
