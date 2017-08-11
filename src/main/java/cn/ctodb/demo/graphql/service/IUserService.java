package cn.ctodb.demo.graphql.service;

import cn.ctodb.demo.graphql.entity.User;

public interface IUserService {
	public abstract User getUserById(int id);
}
