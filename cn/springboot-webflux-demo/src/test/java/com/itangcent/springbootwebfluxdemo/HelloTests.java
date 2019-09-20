package com.itangcent.springbootwebfluxdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itangcent.common.utils.JsonUtil;
import com.itangcent.springbootwebfluxdemo.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = HelloController.class)
public class HelloTests {
    @Autowired
    WebTestClient client;

    @Test
    public void getHello() {
        client.get().uri("/hello").exchange().expectStatus().isOk()
                .expectBody().consumeWith(entityExchangeResult -> {
            String content = new String(entityExchangeResult.getResponseBody());
            if (!content.contains("hello")) {
                throw new IllegalArgumentException("no hello");
            }
        });
    }

    @Test
    public void testList() {
        ObjectMapper objectMapper = new ObjectMapper();
        client.get().uri("/hello/list").exchange().expectStatus().isOk()
                .expectBody().consumeWith(res -> {
                    try {
                        Integer[] value = objectMapper.readValue(res.getResponseBody(), Integer[].class);
                        System.out.println(JsonUtil.toJson(value));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
