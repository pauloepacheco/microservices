package br.com.tms.microservices.support.composite.model;


import java.util.List;
import java.util.stream.Collectors;

import br.com.tms.microservices.core.product.model.Product;
import br.com.tms.microservices.core.recomendation.model.Recommendation;

/**
 * Created by Paulo Pacheco
 */
public class ProductAggregated {
	
    private int productId;
    
    private String name;
    
    private int weight;
    
    private List<RecommendationSummary> recommendations;

    public ProductAggregated(Product product, List<Recommendation> recommendations) {

    	if(product != null){
	        this.productId = product.getProductId();
	        this.name = product.getName();
	        this.weight = product.getWeight();
    	}
        // copy recomendation information if it is available
        if (recommendations != null)
            this.recommendations = recommendations.stream()
                .map(r -> new RecommendationSummary(r.getRecommendationId(), r.getAuthor(), r.getRate()))
                .collect(Collectors.toList());
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<RecommendationSummary> getRecommendations() {
        return recommendations;
    }

}
