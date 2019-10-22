package com.itangcent.springbootwebfluxdemo.controller;

import com.itangcent.springbootwebfluxdemo.reactive.function.Person;
import com.itangcent.springbootwebfluxdemo.reactive.function.PersonHandler;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Auther: layker
 * @Date: 2019-09-20 11:05
 * @Description:
 */
@RestController
@RequestMapping("restful")
public class FluxController {

    private final PersonHandler personHandler;

    public FluxController(PersonHandler personHandler) {
        this.personHandler = personHandler;
    }

    @GetMapping("/")
    public Mono<String> empty() {
        return Mono.empty();
    }

    @GetMapping("/single")
    public Mono<String> single() {
        return Flux.<String>empty().single("single");
    }

    @PostMapping("/person")
    Mono<Void> create(@RequestBody Person person) {
        return this.personHandler.createPerson(person).then();
    }

    @GetMapping("/person")
    Flux<Person> list() {
        return this.personHandler.listPeople();
    }

    @GetMapping("/person/{id}")
    Mono<Person> findById(@PathVariable int id) {
        return this.personHandler.getPerson(id);
    }

    @GetMapping("/error")
    Mono<Person> error() {
        return Mono.error(new RuntimeException("error test with mono"));
    }
}
