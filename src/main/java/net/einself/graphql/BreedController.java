package net.einself.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BreedController {

    private final BreedServiceMemoryImpl breedService;

    public BreedController(BreedServiceMemoryImpl breedService) {
        this.breedService = breedService;
    }

    @QueryMapping
    public List<Breed> breeds() {
        return breedService.findAll();
    }

    @QueryMapping
    public Breed breed(@Argument Long id) {
        return breedService.findOne(id);
    }

    @MutationMapping
    public Breed createBreed(@Argument BreedInput input) {
        return breedService.create(input.name());
    }

}
