package nse.skbh.springboot.boot.backend.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nse.skbh.springboot.boot.backend.mongo.dto.Authorities;

@Repository
public interface AuthorityRepository extends MongoRepository<Authorities, String> {
	
	public Authorities findByAuthority(String authority); 

}
