package br.com.tms.microservices.core.recomendation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * 
 * @author Paulo Pacheco
 *
 */
@Import(MongoDBConfig.class)
public class MongoTemplateDao {
	
	@Autowired
	protected MongoOperations mongoTemplateDao;
}
