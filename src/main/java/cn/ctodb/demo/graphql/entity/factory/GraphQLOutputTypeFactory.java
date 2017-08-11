package cn.ctodb.demo.graphql.entity.factory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import graphql.schema.GraphQLOutputType;
import graphql.schema.GraphQLObjectType;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import graphql.Scalars;

@Component
public class GraphQLOutputTypeFactory implements InitializingBean{

	private GraphQLOutputType  userType;
	
	public GraphQLOutputType getUserType() {
		return userType;
	}

	public void setUserType(GraphQLOutputType userType) {
		this.userType = userType;
	}

	public void afterPropertiesSet() throws Exception {
		userType = GraphQLObjectType.newObject().name("User")
	              .field(newFieldDefinition().name("id").type(Scalars.GraphQLInt).build())
	              .field(newFieldDefinition().name("age").type(Scalars.GraphQLInt).build())
	              .field(newFieldDefinition().name("sex").type(Scalars.GraphQLString).build())
	              .field(newFieldDefinition().name("name").type(Scalars.GraphQLString).build())
	              .field(newFieldDefinition().name("pic").type(Scalars.GraphQLString).build())
	              .build();
	}
	
}
