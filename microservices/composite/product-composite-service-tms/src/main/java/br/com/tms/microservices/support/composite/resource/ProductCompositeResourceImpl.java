package br.com.tms.microservices.support.composite.resource;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tms.microservices.core.product.model.Product;
import br.com.tms.microservices.core.recomendation.model.Recommendation;
import br.com.tms.microservices.support.composite.model.ProductAggregated;
import br.com.tms.microservices.support.composite.service.ProductCompositeIntegration;
import br.com.tms.microservices.support.composite.util.CompositeResponseMapper;

/**
 * 
 * @author Paulo Pacheco
 *
 */
@RestController
public class ProductCompositeResourceImpl implements ProductCompositeResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCompositeResourceImpl.class);
	
	@Autowired
	private ProductCompositeIntegration integrationService;
	
	@Autowired
	private CompositeResponseMapper responseMapper;
	
	
	@Override
	@RequestMapping(value="product/sample", method=RequestMethod.GET)
	public String sampleMethod() {
		return "{\"timestamp\":\"" + new Date() + "\",\"content\":\"Hello from Sample API\"}";
	}

	@Override
	@RequestMapping("/product/{productId}")
	public ResponseEntity<ProductAggregated> getProduct(@PathVariable int productId) {
		ResponseEntity<Product> productResult = integrationService.getProduct(productId);
		
		LOGGER.info("Receiving product request for id: " +productId);
		if(!productResult.getStatusCode().is2xxSuccessful()){
			responseMapper.createResponse(null, productResult.getStatusCode());
		}
		
		List<Recommendation> recommendationList = null;
		try{
			ResponseEntity<List<Recommendation>> recommendationsResult = integrationService.
					getRecomendations(productId);
			
			if(recommendationsResult.getStatusCode().is2xxSuccessful()){
				recommendationList = recommendationsResult.getBody(); 
			}
		}catch(Throwable t){
			LOGGER.error("An error occurred due to: " + t.getMessage(), t);
			throw t;
		}
		
		ResponseEntity<ProductAggregated> response = responseMapper.createOkResponse(new ProductAggregated(
				productResult.getBody(), recommendationList));
		
		return response;
	}
}
