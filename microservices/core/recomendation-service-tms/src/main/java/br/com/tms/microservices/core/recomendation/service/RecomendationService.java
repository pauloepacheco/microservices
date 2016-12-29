package br.com.tms.microservices.core.recomendation.service;

import java.util.List;

import br.com.tms.microservices.core.recomendation.model.Recommendation;

/**
 * 
 * @author Paulo Pacheco
 *
 */
public interface RecomendationService {

	public List<Recommendation> getRecomendations(int productId);
		
}
