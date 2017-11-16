package com.mastermoin.demo.resuource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastermoin.demo.model.User;
import com.mastermoin.demo.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserRepository userRepo;

	@GetMapping
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) {
		return userRepo.findOne(Integer.parseInt(id));
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userRepo.save(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
		User oldUser = userRepo.findOne(Integer.parseInt(id));
		if (oldUser == null) {
			throw new NullPointerException();
		}
		oldUser.setName(user.getName());
		oldUser.setEmail(user.getEmail());
		return userRepo.save(oldUser);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser (@PathVariable String id) {
		userRepo.delete(Integer.parseInt(id));
	}

}
