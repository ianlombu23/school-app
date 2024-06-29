package com.school.app.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(r -> r.path("/school-app/account-service/**")
                        .filters(f -> f.rewritePath("/school-app/account-service/(?<segment>.*)", "/${segment}"))
                        .uri("lb://ACCOUNT"))
                .route(r -> r.path("/school-app/attendance-service/**")
                        .filters(f -> f.rewritePath("/school-app/attendance-service/(?<segment>.*)", "/${segment}"))
                        .uri("lb://ATTENDANCE"))
                .build();

    }
}
