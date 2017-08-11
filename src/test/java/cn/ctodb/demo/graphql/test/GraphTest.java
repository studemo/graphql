package cn.ctodb.demo.graphql.test;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ctodb.demo.graphql.Application;
import cn.ctodb.demo.graphql.entity.factory.GraphQLSchemaFactory;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import net.minidev.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class GraphTest {

	@Autowired
	private GraphQLSchemaFactory schemaFactory;

	@Test
	public void test() {
		GraphQLSchema schema = schemaFactory.getSchema();

		String query1 = "{users(page:2,size:5,name:\"john\") {id,sex,name,pic}}";
		String query2 = "{user(id:6) {id,name,pic}}";
		String query3 = "{user(id:6) {id,sex,name,pic},users(page:2,size:5,name:\"john\") {id,sex,name,pic}}";

		Map<String, Object> user = GraphQL.newGraphQL(schema).build().execute(query2).getData();

		// 查询用户列表
		System.out.println(JSONObject.toJSONString(user));

	}

}
