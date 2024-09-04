package net.einself.graphql;

import java.util.List;

public interface BreedService {

    Breed create(String name);
    List<Breed> findAll();
    Breed findOne(Long id);

}
