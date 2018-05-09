package com.maxrocky.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yado
 * @create 2018-05-09 8:57
 * @desc  主要看application.yml文件
 **/
@RestController
public class main {

    //如果没有编写配置文件，此处可以直接使用${random.value}
    @Value("${my.value}")
    private String value;

    //如果没有编写配置文件，此处可以直接使用${random.int}
    //int类型也可以换成String类型
    @Value("${my.int}")
    private int randomInt;

    //如果没有编写配置文件，此处可以直接使用${random.long}
    //long类型也可以换成String类型
    @Value("${my.long}")
    private long randomLong;

    //没有random.float和random.double类型，他们只会默认转成random.value随机字符串

    //如果没有编写配置文件，此处可以直接使用${random.uuid}
    //int类型也可以换成String类型
    @Value("${random.uuid}")
    private String randomUuid;

    //如果没有编写配置文件，此处可以直接使用${random.int(10)}
    //int类型也可以换成String类型
    @Value("${my.int.less.than.ten}")
    private int randomIntLessThanTen;

    // 如果没有编写配置文件，此处可以直接使用${random.int[100,1000]}
    //int类型也可以换成String类型
    @Value("${my.int.in.range}")
    private int randomIntInRange;

    @Value("${random.int}")
    private int anInt;

    @Value("#{T(java.lang.Math).random() * 10}")
    //详情查看springEL和资源调用
    private int bInt;

    /**
     * 不走http请求全部都是空值
     */
    @Test
    public void test(){
        System.out.println(value);
        System.out.println(randomInt);
        System.out.println(randomLong);
        System.out.println(randomUuid);
        System.out.println(randomIntLessThanTen);
        System.out.println(randomIntInRange);
        System.out.println("-------");
        System.out.println(anInt);
        System.out.println(bInt);
    }

    @GetMapping("/get")
    public String get(){
        test();
        return "SUCCESS";
    }

}