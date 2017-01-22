package br.com.tms.microservices.core.product.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tms.microservices.core.product.model.Product;

/**
 * 
 * @author Paulo Pacheco
 *
 */
@RestController
public class ProductResourceImpl implements ProductResource{

	@Override
	@RequestMapping("/product/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return new Product(productId, "name", 123);
    }

}
