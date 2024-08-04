package study.configuration;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class RouteConfiguration {
	
	
	@Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
        		
                .route("customerModule", r -> r.path("/customer/**")
                .uri("http://localhost:8081/"))
                                        
                .route("employeeModule", r -> r.path("/employee/**")
                .uri("http://localhost:8082/"))
                        
                .build();
    }
	
	@Bean
	GlobalFilter globalFilter() {
		return (exchange, chain) -> {
			System.out.println("First Global filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("Second Global filter");
			}));
		};
	}
	
}
