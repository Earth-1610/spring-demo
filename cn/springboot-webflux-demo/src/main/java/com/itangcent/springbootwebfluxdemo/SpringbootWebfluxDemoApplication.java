package com.itangcent.springbootwebfluxdemo;

import com.itangcent.springbootwebfluxdemo.reactive.function.DummyPersonRepository;
import com.itangcent.springbootwebfluxdemo.reactive.function.PersonHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class SpringbootWebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebfluxDemoApplication.class, args);
    }


    @Bean
    public PersonHandler personHandler() {
        return new PersonHandler(new DummyPersonRepository());
    }

    /**
     * 通过注入RouterFunction实现http接口定义
     * todo  是否支持easyapi解析支持?
     *
     * @param personHandler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> routingFunction(PersonHandler personHandler) {
        return nest(path("/person"),
                nest(accept(APPLICATION_JSON),
                        route(GET("/{id}"), personHandler::getPerson)
                                .andRoute(method(HttpMethod.GET), personHandler::listPeople)
                ).andRoute(POST("/").and(contentType(APPLICATION_JSON)), personHandler::createPerson));
    }
}
