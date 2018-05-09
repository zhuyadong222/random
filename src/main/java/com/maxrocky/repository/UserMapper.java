package com.maxrocky.repository;

import com.maxrocky.dto.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @author yado
 * @create 2018-03-30 16:43
 * @desc
 **/
@Mapper
public interface UserMapper {

    @Insert("insert into user values (null, #{name})")
    void saveUser(User user);

    @Select("select * from user where id = #{id}")
    User getUser(Integer id);

    @Update("update user set name = #{name} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    void removeUser(Integer id);
}