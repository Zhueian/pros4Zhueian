package com.imooc.pro4pro4Interview.miaosha.dao;

import com.imooc.pro4pro4Interview.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: qiucy
 * @Date: 2019-05-07 12:56
 * @Description:
 */
@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User getzById(@Param("id") int id);

    @Insert("insert into user (id,name) value(#{id},#{name})")
    Boolean insert(User user);
}
