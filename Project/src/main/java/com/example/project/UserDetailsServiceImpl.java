package com.example.project;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            createUser("admin", "$2a$10$sJcw3bTHLUGVZt.BNBtukObz4OZNpZhZqFSFpZnK363FLL9Sflnce", "ROLE_ADMIN");
            createUser("user", "$2a$10$8Vmlpg2Z0B7RDsRVYyvlgOoXbYeYgHtiMCnZAYT6g6pleaM9UAFlC", "ROLE_USER");
        }
    }

    private void createUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userRepository.save(user);
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyUserDetails(user);
	}

}
