package study.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

	@Bean
        RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customerModule",r -> r.path("/customer/**")
                .uri("http://localhost:8081/"))
                        

                .route("employeeModule", r -> r.path("/employee/**")
                        .uri("http://localhost:8082/"))
                        
                .build();
    }
	
}
