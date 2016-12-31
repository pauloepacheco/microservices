package br.com.tms.microservices.core.recomendation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tms.microservices.core.recomendation.dao.RecommendationDao;
import br.com.tms.microservices.core.recomendation.model.Recommendation;

/**
 * 
 * @author Paulo Pacheco
 *
 */
@RestController
public class RecomendationServiceImpl implements RecomendationService {

	@Autowired
	private transient RecommendationDao recommendationDao;

	@Override
	@RequestMapping("/recommendation")
	public List<Recommendation> getRecomendations(
			@RequestParam(value = "productId",  required = true) int productId) {
		
		return recommendationDao.getRecommendationsByProductId(productId);
	}	
}
