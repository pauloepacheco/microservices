package br.com.tms.microservices.core.product.test.ws;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.tms.microservices.core.product.test.util.WebTestConfiguration;

/**
 * 
 * @author Paulo Pacheco
 *
 */
public class ProductWSTest extends WebTestConfiguration{

	@Test
	public final void getProductTest() throws Exception{
		super.mockMvc.perform(MockMvcRequestBuilders.
       		 get("/product/1"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
               .andReturn();
	}
}
