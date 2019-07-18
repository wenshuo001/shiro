package com.example.shiro.service;


import com.example.shiro.bean.Category;
import com.example.shiro.bean.User;
import com.example.shiro.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryByBrandId(Long bid) {
        return this.categoryMapper.queryByBrandId(bid);
    }


    public User findUserByName(String userName) {
        return categoryMapper.findUserByName(userName);
    }
}
