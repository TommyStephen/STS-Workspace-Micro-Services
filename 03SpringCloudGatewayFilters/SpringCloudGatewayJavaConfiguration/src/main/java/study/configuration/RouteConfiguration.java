package study.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
	
	//Pre (addRequestHeader) and Post(addResponseHeader) Filters provided by Spring Cloud Gateway
	
	@Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
        		
                .route("customerModule", r -> r.path("/customer/**")
                .filters(f -> f.addRequestHeader("first-request", "customer-request-header")
                		.addResponseHeader("first-response", "customer-response-header"))
                .uri("http://localhost:8081/"))
                                        

                .route("employeeModule", r -> r.path("/employee/**")
                	.filters(f -> f.addRequestHeader("second-request", "employee-request-header")
						.addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082/"))
                        
                .build();
    }
	
}
