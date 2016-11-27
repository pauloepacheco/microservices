package br.com.tms.microservices.core.product.resource;

import org.springframework.web.bind.annotation.PathVariable;

import br.com.tms.microservices.core.product.model.Product;

/**
 * 
 * @author Paulo Pacheco
 *
 */
public interface ProductResource {

	public Product getProduct(@PathVariable int productId);
}
