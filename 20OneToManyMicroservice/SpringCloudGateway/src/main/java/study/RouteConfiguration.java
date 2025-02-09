package study;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route("ParentService", r->r.path("/parent/**")
				.uri("http://localhost:8081/"))
				
				.route("ChildService", r->r.path("/child/**")
				.uri("http://localhost:8082"))
				
				.build();				
	}
	
//	@Bean
//    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("parent-service", r -> r.path("/parent/**")
//                        .uri("lb://PARENT-SERVICE")) // Use load balancer URI
//                .route("child-service", r -> r.path("/child/**")
//                        .uri("lb://CHILD-SERVICE")) // Use load balancer URI
//                .build();
//    }
}
