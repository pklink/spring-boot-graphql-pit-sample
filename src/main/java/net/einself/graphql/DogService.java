package net.einself.graphql;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DogService {

    private final static List<Dog> DOGS = new ArrayList<>(List.of(
            new Dog(1L, 1L, "Riley"),
            new Dog(2L, 1L, "Scout"),
            new Dog(3L, 2L, "Echo"),
            new Dog(4L, 4L, "Dakota"),
            new Dog(5L, 4L, "River"),
            new Dog(6L, 5L, "Blaze")
    ));

    public List<Dog> findAll() {
        return DOGS;
    }

    public Dog findOne(Long id) {
        return DOGS.stream()
                .filter(dog -> Objects.equals(dog.id(), id))
                .findFirst()
                .orElse(null);
    }

}
