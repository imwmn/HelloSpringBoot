package com.wmn.HelloSpringBoot.config;

import com.wmn.HelloSpringBoot.Repository.UserRepository;
import com.wmn.HelloSpringBoot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * 路由器函数 配置
 */
@Configuration
public class RouterFunctionConfig {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> pesonFindAll(UserRepository userRepository){
       return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),serverRequest -> {
            Collection<User> users = userRepository.findAll();
            Mono<ServerResponse> responseMono = null;
            Flux<User> userFlux = Flux.fromIterable(users);
            return ServerResponse.ok().body(userFlux,User.class);
        });

    }
}
