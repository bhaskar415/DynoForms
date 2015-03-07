package com.app.functional.dynoforms.persistence.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.functional.dynoforms.persistence.eo.FormsEO;

import java.lang.String;

@RepositoryRestResource(collectionResourceRel = "forms", path = "forms")
public interface FormsDAO extends MongoRepository<FormsEO, String>{


      List<FormsEO> findById(String id);
 
		
	
}
