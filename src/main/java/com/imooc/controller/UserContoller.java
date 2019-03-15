package com.imooc.controller;

import com.imooc.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@Controller
@RestController		// @RestController = @Controller + @ResponseBody
@RequestMapping("/user")
public class UserContoller {

	@RequestMapping("/getUser")
//	@ResponseBody
	public User getUser() {
		
		User u = new User();
		u.setName("imooc");
		u.setAge(21);
		u.setBirthday(new Date());
		u.setPassword("imooc");
		u.setDesc("hello imooc~~");
		
		return u;
	}
	/*@RequestMapping("/getUserJson")
//	@ResponseBody
	public IMoocJSONResult getUserJson() {

		User u = new User();
		u.setName("imooc");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("imooc");
		u.setDesc("hello imooc~~hello imooc~~");

		return IMoocJSONResult.ok(u);
	}*/


}
