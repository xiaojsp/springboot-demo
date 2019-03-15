package com.imooc.controller;

import com.imooc.entity.Userinfo;
import com.imooc.repository.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hibernate")
@EnableAutoConfiguration//此注释自动载入应用程序所需的所有Bean
public class HibernateController {

    @Autowired
    private UserinfoRepository userinfoRepository;

    @RequestMapping("/getUserinfoById")
    @ResponseBody
    public Userinfo getUserinfoById(Integer id) {
        Userinfo u = userinfoRepository.findOne(id);
        System.out.println("userRepository: " + userinfoRepository);
        System.out.println("id: " + id);
        return u;
    }

    /*@RequestMapping("saveUserinfo")
     * RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
     * */

    /*@ResponseBody
     *  i) 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
     * ii) 再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上。
     * */
    @RequestMapping("/saveUserinfo")
    @ResponseBody
    public Userinfo saveUserinfo() {//注意 @RequestMapping("saveUserinfo")里的value值要与方法名称一致，否则找不到
        Userinfo userinfoEntity = new Userinfo();
        userinfoEntity.setName("苹果");
        userinfoEntity.setMale(1);
        userinfoEntity.setAge(20);
        userinfoEntity.setHobit("足球");
        userinfoEntity.setRemark("专业");

        userinfoRepository.save(userinfoEntity);
        return userinfoEntity;
    }
}
