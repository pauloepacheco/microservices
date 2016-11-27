package br.com.tms.microservices.support.composite.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.tms.microservices.core.product.model.Product;
import br.com.tms.microservices.core.recomendation.model.Recommendation;

/**
 * 
 * @author Paulo Pacheco
 *
 */
public interface ProductCompositeIntegration {

	public ResponseEntity<Product> getProduct(int productId);
	public ResponseEntity<List<Recommendation>> getRecomendations(int productId);
}
