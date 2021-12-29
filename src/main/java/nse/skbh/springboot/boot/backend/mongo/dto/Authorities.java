package nse.skbh.springboot.boot.backend.mongo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Authorities {
	@Id
    private String id;
	
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String authority;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
    
}
