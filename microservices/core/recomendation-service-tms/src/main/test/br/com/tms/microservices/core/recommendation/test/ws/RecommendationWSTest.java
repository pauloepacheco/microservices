package br.com.tms.microservices.core.recommendation.test.ws;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.tms.microservices.core.recommendation.test.util.WebTestConfiguration;

import org.hamcrest.Matchers;

/**
 * 
 * @author Paulo Pacheco
 *
 */
public class RecommendationWSTest extends WebTestConfiguration {
    
    @Test
    public final void getRecommendationTest() throws Exception{
        MvcResult result = (MvcResult) super.mockMvc.perform(MockMvcRequestBuilders.
        		 get("/recommendation?productId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].author", Matchers.is("Paulo")))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
}
