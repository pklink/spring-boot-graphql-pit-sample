package net.einself.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DogController {

    private final BreedServiceMemoryImpl breedService;
    private final DogService dogService;

    public DogController(BreedServiceMemoryImpl breedService, DogService dogService) {
        this.breedService = breedService;
        this.dogService = dogService;
    }

    @SchemaMapping(typeName = "Dog", field = "breed")
    public Breed breed(Dog dog) {
        return breedService.findOne(dog.breedId());
    }

    @QueryMapping
    public List<Dog> dogs() {
        return dogService.findAll();
    }

    @QueryMapping
    public Dog dog(@Argument Long id) {
        return dogService.findOne(id);
    }

}
