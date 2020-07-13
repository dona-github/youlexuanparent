package com.offcn.sellergoods.service;

import com.offcn.entity.PageResult;
import com.offcn.pojo.TbBrand;

import java.util.List;

public interface BrandService {
    // 查询全部数据
    public List<TbBrand> findAll();
    //分页显示(需要前端传递每页展示的页数和当前页码)
    public PageResult findPage(int pageNum,int pageSize);
    //增加
    public void add(TbBrand brand);

    public TbBrand findOne(Long id);

    public void update(TbBrand brand);

    public void delete(Long[] ids);
}
