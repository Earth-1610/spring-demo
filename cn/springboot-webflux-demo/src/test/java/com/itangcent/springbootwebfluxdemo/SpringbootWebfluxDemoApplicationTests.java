package com.itangcent.springbootwebfluxdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RunWith(SpringRunner.class)
@WebFluxTest
@ComponentScan(basePackages = "com.itangcent.springbootwebfluxdemo")
public class SpringbootWebfluxDemoApplicationTests {


    @Autowired
    WebTestClient client;
    
    /**
     * @see com.itangcent.springbootwebfluxdemo.controller.EntityCtrl#intInEntity(String)
     */
    @Test
    public void test_intInEntity() {

        client.post().uri("/test/entity/int").header("token", "test-token")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus()
                .isOk();

    }

    /**
     * @see com.itangcent.springbootwebfluxdemo.controller.EntityCtrl#doubleInEntity(String)
     */
    @Test
    public void test_doubleInEntity() {

        client.post().uri("/test/entity/double").header("token", "test-token")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus()
                .isOk();
    }

    /**
     * @see com.itangcent.springbootwebfluxdemo.controller.FileCtrl
     */
    @Test
    public void testFileCtrl() {

        MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
//        ClassPathResource("test-image.jpg").file.readBytes()
        bodyBuilder.part("profileImg", "<<png data>>".getBytes())
                .header("Content-Disposition", "form-data; name=profileImg; filename=profile-image.jpg");

//        ClassPathResource("test-document.pdf").file.readBytes()
//        bodyBuilder.part("userDocument", "1 2 3 4 5".getBytes()).header("Content-Disposition", "form-data; name=userDocument; filename=my-thesis.pdf");

        bodyBuilder.part("name", "shiveenpandita", MediaType.TEXT_PLAIN).header("Content-Disposition", "form-data; name=name").header("Content-type", "text/plain");

        bodyBuilder.part("age", "12", MediaType.TEXT_PLAIN).header("Content-Disposition", "form-data; name=age").header("Content-type", "text/plain");

        client.post()
                .uri("/file/add")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(bodyBuilder.build()))
                .exchange()
                .expectStatus().isOk();

    }

}
