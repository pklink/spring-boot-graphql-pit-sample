package net.einself.graphql;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BreedServiceMemoryImpl implements BreedService {

    private final static List<Breed> BREEDS = new ArrayList<>(List.of(
            new Breed(1L, "Poodle"),
            new Breed(2L, "Rottweiler"),
            new Breed(3L, "Yorkshire Terrier"),
            new Breed(4L, "Boxer"),
            new Breed(5L, "Dachshund")
    ));

    @Override
    public Breed create(String name) {
        Long id = BREEDS.size() + 1L;
        Breed breed = new Breed(id, name);
        BREEDS.add(breed);
        return breed;
    }

    @Override
    public List<Breed> findAll() {
        return BREEDS;
    }

    @Override
    public Breed findOne(Long id) {
        return BREEDS.stream()
                .filter(breed -> Objects.equals(breed.id(), id))
                .findFirst()
                .orElse(null);
    }

}
