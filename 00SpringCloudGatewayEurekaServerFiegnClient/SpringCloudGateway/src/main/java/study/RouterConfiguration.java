package study;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfiguration {

	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("InventoryService", r->r.path("/inventory/**")
				.uri("http://localhost:8081/"))
				
				.route("ProductService", r->r.path("/product/**")
				.uri("http://localhost:8082"))
				
				.route("OrderService", r->r.path("/order/**")
						.uri("http://localhost:8083"))
				
				.build();		
	}
}
