package cn.ctodb.demo.graphql.entity.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ctodb.demo.graphql.service.IUserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GraphQLFetcherFactory implements DataFetcher<Object> {

	@Autowired
	private IUserService userService;

	@Override
	public Object get(DataFetchingEnvironment environment) {
		return userService.getUserById(environment.getArgument("id"));
	}

}
