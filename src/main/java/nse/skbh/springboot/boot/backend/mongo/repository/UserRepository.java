package nse.skbh.springboot.boot.backend.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nse.skbh.springboot.boot.backend.mongo.dto.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
	
	public Users findByUsername(String username);
	public List<Users> findAll();
}
