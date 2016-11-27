package br.com.tms.microservices.support.composite.util;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;


/**
 * 
 * @author Paulo Pacheco
 *
 */

@Component
public class BalancerUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BalancerUtil.class);

	@Autowired
	private LoadBalancerClient loadBalancer;
	
	public URI getServiceURL(String serviceId, String endpoint){
		URI uri = null;
		try{
			ServiceInstance instance = loadBalancer.choose(serviceId);
			uri = instance.getUri();
		}catch(RuntimeException e){
			//eureka not available
			LOGGER.error("Runtime exception on load balancer service due to: " + e.getMessage(),e);
			uri = URI.create(endpoint);
		}
		return uri;
	}
}
