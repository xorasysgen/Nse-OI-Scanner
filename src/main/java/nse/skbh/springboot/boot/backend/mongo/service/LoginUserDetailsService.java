package nse.skbh.springboot.boot.backend.mongo.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nse.skbh.springboot.boot.backend.mongo.dto.Authorities;
import nse.skbh.springboot.boot.backend.mongo.dto.Users;
import nse.skbh.springboot.boot.backend.mongo.repository.AuthorityRepository;
import nse.skbh.springboot.boot.backend.mongo.repository.UserRepository;

@Service
public class LoginUserDetailsService  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	private List<GrantedAuthority> getUserAuthority(List<Authorities> list) {
	    Set<GrantedAuthority> roles = new HashSet<>();
	    list.forEach((role) -> {
	        roles.add(new SimpleGrantedAuthority(role.getAuthority()));
	    });

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepository.findByUsername(username);
		if(users != null) {
	        List<GrantedAuthority> authorities = getUserAuthority(users.getAuthorities());
	        return buildUserForAuthentication(users, authorities);
	    } else {
	        throw new UsernameNotFoundException("username not found");
	    }
	}

	private UserDetails buildUserForAuthentication(Users users, List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), authorities);
	}
	
	public Users findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<Users> findAllUsers() {
		return userRepository.findAll();
	}
	
	
	public Users createUser(Users users) {
	    users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
	    users.setEnabled(true);
	    List<Authorities> list=new ArrayList<Authorities>();
	    for (Authorities authorities2 : users.getAuthorities()) {
	    	Authorities userRole = authorityRepository.findByAuthority(authorities2.getAuthority());
	    	list.add(userRole);
		}
	    users.setAuthorities(list);
	   return  userRepository.save(users);
	}
	

	public UserRepository getUserRepository() {
		return userRepository;
	}


	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public AuthorityRepository getRoleRepository() {
		return authorityRepository;
	}


	public void setRoleRepository(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}


	public BCryptPasswordEncoder getbCryptPasswordEncoder() {
		return bCryptPasswordEncoder;
	}


	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	
	
	
}
