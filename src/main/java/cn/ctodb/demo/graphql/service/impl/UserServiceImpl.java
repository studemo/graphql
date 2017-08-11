package cn.ctodb.demo.graphql.service.impl;

import org.springframework.stereotype.Service;

import cn.ctodb.demo.graphql.entity.User;
import cn.ctodb.demo.graphql.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	public User getUserById(int id) {
		User user = new User();
		if(id==7){
			user.setAge(12);
			user.setId(1);
			user.setName("hello");
			user.setPic("photo");
			user.setSex("男");
		}else{
			user.setName("ddd");
		}
		
		return user;
	}

}
