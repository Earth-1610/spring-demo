/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.itangcent.springbootwebfluxdemo;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class PersonHandler {

    private final PersonRepository repository;

    public PersonHandler(PersonRepository repository) {
        this.repository = repository;
    }

    public Mono<Person> getPerson(int personId) {
        return Mono.justOrEmpty(this.repository.getPerson(personId));
    }

    public Mono<Void> createPerson(Person person) {
        return Mono.justOrEmpty(person).doOnNext(repository::savePerson).thenEmpty(Mono.empty());
    }

    public Flux<Person> listPeople() {
        return Flux.fromIterable(this.repository.allPeople());
    }

}
