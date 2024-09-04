# Sample: Spring Boot & GraphQL

Sample application using Spring Boot and GraphQL

## Features

* Spring Boot
* GraphQL via HTTP
  * Queries
  * Mutations
  * Schema mapping
  * HTTP testing

### Todo

* [ ] Validation for mutations

## Resources

* https://docs.spring.io/spring-boot/index.html
* https://docs.spring.io/spring-graphql/reference/index.html
* https://graphql.org/learn/


## GraphQL

For more details check the [`schema.graphqls`](./src/main/resources/graphql/schema.graphqls) file

### Queries

* `breeds: [Breed]`
* `breed(id: ID): Breed`
* `dogs: [Dog]`
* `dog(id: ID): Dog`

### Mutations

* `createBreed(input: BreedInput): Breed`
* `createDog(input: DogInput): Dog`

## Build & run

```shell
mvn clean install spring-boot:run
```