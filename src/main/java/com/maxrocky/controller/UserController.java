package com.maxrocky.controller;

import com.maxrocky.dto.User;
import com.maxrocky.repository.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yado
 * @create 2018-03-30 16:37
 * @desc
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Value("${user.username:yado}")
    private String name;

    @Value("${user.age:23}")
    private Integer age;

    @Value("${random.value}")
    private String value;

    @Value("${random.int}")
    private Integer num;

    @Value("${random.long}")
    private long a;

    @Value("${random.int(10)}")
    private double test1;

    @Value("${random.int[10,20]}")
    private int test2;

    @Value("${user.desc}")
    private String desc;

    /**
     * 这些属性注入，不经过前台请求，输出到控制台的数据都是空值
     * I don't know why?
     */
    @Test
    public void test(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(value);
        System.out.println(num);
        System.out.println(a);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(desc);
    }

    @GetMapping(value = "/get")
    public String get(){
        test();
        return "SUCCESS";
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userMapper.saveUser(user);
        return "SUCCESS";
    }

    @GetMapping(value = "/get/{id}")
    public User getUser(@PathVariable Integer id){
        User user = userMapper.getUser(id);
        return user;
    }

    @PutMapping(value = "/update")
    public String updateUser(@RequestBody User user){
        userMapper.updateUser(user);
        return "SUCCESS";
    }

    @DeleteMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable Integer id){
        userMapper.removeUser(id);
        return "sucCEss";
    }

}