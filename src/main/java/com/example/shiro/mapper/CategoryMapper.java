package com.example.shiro.mapper;

import com.example.shiro.bean.Category;
import com.example.shiro.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface CategoryMapper extends Mapper<Category> {
    /**
     * 根据品牌id查询商品分类
     * @param bid
     * @return
     */
    @Select("SELECT * FROM tb_category WHERE id IN (SELECT category_id FROM tb_category_brand WHERE brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);


    @Select("SELECT * FROM USER WHERE USERNAME = #{userName}")
    User findUserByName(@Param("userName") String userName);
}