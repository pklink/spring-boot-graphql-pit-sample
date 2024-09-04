package net.einself.graphql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BreedControllerTest {

    @LocalServerPort
    private int port;

    private HttpGraphQlTester tester;

    @BeforeEach
    void setUp() {
        WebTestClient client = WebTestClient.bindToServer()
                .baseUrl(String.format("http://localhost:%d/graphql", port))
                .build();

        tester = HttpGraphQlTester.create(client);
    }

    @Test
    void create() {
        tester.documentName("create-breed")
                .execute()
                .path("data.createBreed")
                .entity(Breed.class)
                .matches(breed -> Objects.equals(breed.id(), 6L))
                .matches(breed -> Objects.equals(breed.name(), "Labrador"));
    }

    @Test
    void breed() {
        tester.documentName("breed")
                .variable("id", 1L)
                .execute()
                .path("data.breed")
                .entity(Breed.class)
                .matches(breed -> Objects.equals(breed.id(), 1L))
                .matches(breed -> Objects.equals(breed.name(), "Poodle"));
    }

    @Test
    void breeds() {
        tester.documentName("breeds")
                .execute()
                .path("data.breeds")
                .entityList(Breed.class)
                .hasSize(5);
    }

}