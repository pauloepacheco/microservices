package br.com.tms.microservices.core.recomendation.dao;

import java.util.List;

import br.com.tms.microservices.core.recomendation.model.Recommendation;

/**
 * 
 * @author Paulo Pacheco
 *
 */
public interface RecommendationDao {

	List<Recommendation> getRecommendationsByProductId(int productId);
	
	void insertRecommendations(int productId);
}
