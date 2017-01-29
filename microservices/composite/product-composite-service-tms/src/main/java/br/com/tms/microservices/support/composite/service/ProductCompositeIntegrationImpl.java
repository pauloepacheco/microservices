package br.com.tms.microservices.support.composite.service;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.tms.microservices.core.product.model.Product;
import br.com.tms.microservices.core.recomendation.model.Recommendation;
import br.com.tms.microservices.support.composite.util.BalancerUtil;
import br.com.tms.microservices.support.composite.util.CompositeResponseMapper;

/**
 * 
 * @author Paulo Pacheco
 *
 */
@Component
public class ProductCompositeIntegrationImpl implements ProductCompositeIntegration {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCompositeIntegrationImpl.class);
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private BalancerUtil balancerUtil;
	
	@Autowired
	private CompositeResponseMapper responseMapper;
	
	@Override
	@HystrixCommand(fallbackMethod = "defaultProduct")
	public ResponseEntity<Product> getProduct(int productId) {	
		URI uri = balancerUtil.getServiceURL("product-tms", "http://localhost:8081/product");
        String url = uri.toString() + "/product/" + productId;
        LOGGER.debug("GetProduct from URL: {}", url);

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
        Product product = responseMapper.response2Product(resultStr);
        return responseMapper.createOkResponse(product);
	}

	@Override
	@HystrixCommand(fallbackMethod = "defaultRecommendations")
	public ResponseEntity<List<Recommendation>> getRecomendations(int productId) {
		URI uri = balancerUtil.getServiceURL("recommendation-tms", "http://localhost:8081/recommendation");
		String url = uri.toString() + "/recommendation?productId=" + productId;
		LOGGER.debug("GetRecommendations from URL: {}", url);
		ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
		List<Recommendation> recommendationList = responseMapper.response2Recommendation(result);
		return responseMapper.createOkResponse(recommendationList);
	}
	
	public ResponseEntity<Product> defaultProduct(int productId) {
        LOGGER.warn("Using fallback method for product-service");
        return responseMapper.createResponse(null, HttpStatus.BAD_GATEWAY);
    }
	
	public ResponseEntity<List<Recommendation>> defaultRecommendations(int productId) {
        LOGGER.warn("Using fallback method for recommendation-service");
        return responseMapper.createResponse(null, HttpStatus.BAD_GATEWAY);
    }
	
	
}
