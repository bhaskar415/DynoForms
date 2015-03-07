package com.app.functional.dynoforms.persistence.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.functional.dynoforms.persistence.eo.FormDataEO;


@RepositoryRestResource(collectionResourceRel = "formsData", path = "formsData")
public interface FormDataDAO  extends MongoRepository<FormDataEO, String>{

}
