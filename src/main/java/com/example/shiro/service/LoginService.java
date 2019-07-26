package com.example.shiro.service;


import com.example.shiro.bean.User;
import com.example.shiro.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper categoryMapper;

//    public List<Category> queryByBrandId(Long bid) {
//        return this.categoryMapper.queryByBrandId(bid);
//    }


    public User findUserByName(String userName) {
        return categoryMapper.findUserByName(userName);
    }
}
