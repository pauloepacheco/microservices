package br.com.tms.microservices.support.composite.resource;

import org.springframework.http.ResponseEntity;

import br.com.tms.microservices.support.composite.model.ProductAggregated;


/**
 * 
 * @author Paulo Pacheco
 *
 */

public interface ProductCompositeResource {

	public String sampleMethod();
	public ResponseEntity<ProductAggregated> getProduct(int productId);
}
