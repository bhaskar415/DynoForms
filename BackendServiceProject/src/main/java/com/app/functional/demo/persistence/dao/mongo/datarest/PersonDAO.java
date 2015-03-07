package com.app.functional.demo.persistence.dao.mongo.datarest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.functional.demo.persistence.eo.PersonEO;


@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonDAO extends MongoRepository<PersonEO, String>{

}
