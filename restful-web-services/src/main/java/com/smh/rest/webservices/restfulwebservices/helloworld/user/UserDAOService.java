package com.smh.rest.webservices.restfulwebservices.helloworld.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1, "Muzahid", LocalDate.now().minusYears(43)));
		users.add(new User(2, "Zahid", LocalDate.now().minusYears(35)));
		users.add(new User(3, "Feroz", LocalDate.now().minusYears(30)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		return users.stream()
				    .filter(user -> Objects.equals(user.getId(),id))
				    .findFirst().orElse(null);
	}
	
	public User save(User user) {
		users.add(user);
		return user;
	}

    public void delete(int id) {
        users.removeIf(user -> Objects.equals(user.getId(),id));
    }
}
