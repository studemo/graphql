package cn.ctodb.demo.graphql.entity.factory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import static graphql.schema.GraphQLArgument.newArgument;

@Component
public class GraphQLFieldDefinitionFactory implements InitializingBean{
	
	private GraphQLFieldDefinition  fieldDefiniton;
	
	@Autowired
	private GraphQLOutputTypeFactory typeService;
	@Autowired
	private GraphQLFetcherFactory fetcherFactory;

	public void afterPropertiesSet() throws Exception {
		fieldDefiniton = GraphQLFieldDefinition.newFieldDefinition()
	       .name("user")
	       .argument(newArgument().name("id").type(Scalars.GraphQLInt).build())
	       .type(typeService.getUserType())
	       .dataFetcher(fetcherFactory)
	       .build();
	}
	

	public GraphQLFieldDefinition getFieldDefiniton() {
		return fieldDefiniton;
	}

	public void setFieldDefiniton(GraphQLFieldDefinition fieldDefiniton) {
		this.fieldDefiniton = fieldDefiniton;
	}
	
}
