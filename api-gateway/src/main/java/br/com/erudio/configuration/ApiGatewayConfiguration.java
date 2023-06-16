package br.com.erudio.configuration;


import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec -> predicateSpec.path("/get")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec
                                .addRequestHeader("Hello", "World")
                                .addRequestParameter("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(predicateSpec -> predicateSpec.path("/cambio-service/**").uri("lb://cambio-service"))
                .route(predicateSpec -> predicateSpec.path("/book-service/**").uri("lb://book-service"))
                .build();
    }

}
