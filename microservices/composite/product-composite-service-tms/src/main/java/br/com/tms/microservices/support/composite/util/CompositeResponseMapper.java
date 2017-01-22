package br.com.tms.microservices.support.composite.util;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import br.com.tms.microservices.core.product.model.Product;
import br.com.tms.microservices.core.recomendation.model.Recommendation;
import br.com.tms.microservices.support.composite.model.RecommendationSummary;

/**
 * 
 * @author Paulo Pacheco
 *
 */
@Component
public class CompositeResponseMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompositeResponseMapper.class);
	
	private ObjectReader productReader = null;
	
	private ObjectReader getProductReader(){
		if(productReader != null) return productReader;
		ObjectMapper mapper = new ObjectMapper();
		
		return productReader = mapper.reader(Product.class);
	}
	
	public Product response2Product(ResponseEntity<String> response){
		try {
			return getProductReader().readValue(response.getBody());
		} catch (IOException e) {
			LOGGER.error("IOException when trying to convert product response due to: " + 
					e.getMessage(),e);
			throw new RuntimeException(e);
		}
	}
	
	public List<Recommendation> response2Recommendation(ResponseEntity<String> response){
		ObjectMapper mapper = new ObjectMapper();
		try {
			List list = mapper.readValue(response.getBody(),  new TypeReference<List<Recommendation>>() {});
			List<Recommendation> recommendationList = list;
			return recommendationList;
		} catch (IOException e) {
			LOGGER.error("IOException when trying to convert product response due to: " + 
					e.getMessage(),e);
			throw new RuntimeException(e);
		} catch(RuntimeException e){
			LOGGER.error("RuntimeException due to: " + e.getMessage(),e);
			throw e;
		}
	}
	
	public <T> ResponseEntity<T> createOkResponse(T body) {
        return createResponse(body, HttpStatus.OK);
    }

    public <T> ResponseEntity<T> createResponse(T body, HttpStatus httpStatus) {
        return new ResponseEntity<>(body, httpStatus);
    }

}
