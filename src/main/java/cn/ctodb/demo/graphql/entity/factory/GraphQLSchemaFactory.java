package cn.ctodb.demo.graphql.entity.factory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static graphql.schema.GraphQLObjectType.newObject;
import graphql.schema.GraphQLSchema;

@Component
public class GraphQLSchemaFactory implements InitializingBean{

	private GraphQLSchema schema;
	
	@Autowired
	private GraphQLFieldDefinitionFactory definitonFactory;
		
	public void afterPropertiesSet() throws Exception {
		  schema = GraphQLSchema.newSchema().query(newObject()
	                .name("GraphQuery")
	                .field(definitonFactory.getFieldDefiniton())
	                .build()).build();
		
	}
	
	public GraphQLSchema getSchema() {
		return schema;
	}

	public void setSchema(GraphQLSchema schema) {
		this.schema = schema;
	}
	
}
