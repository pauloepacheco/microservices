package br.com.tms.microservices.core.recomendation.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import br.com.tms.microservices.core.recomendation.model.Recommendation;

/**
 * 
 * @author Paulo Pacheco
 *
 */
@Repository
public class RecommendationDaoImpl extends MongoTemplateDao implements RecommendationDao {

	@Override
	public List<Recommendation> getRecommendationsByProductId(int productId) {
		Query query = new Query(Criteria.where("productId").is(productId));
		List<Recommendation> result = mongoTemplateDao.find(query, Recommendation.class);
		return result;
	}
	
	@Override
	public void insertRecommendations(int productId) {
		List<Recommendation> list = new ArrayList<>();
		list.add(new Recommendation(productId, 1, "Paulo", 1, "Content 1"));
		list.add(new Recommendation(productId, 2, "Eduardo", 2, "Content 2"));
		mongoTemplateDao.insert(list, Recommendation.class);		
	}

}
