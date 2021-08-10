package com.phoenix.services;
/*
 * @Author vimal.makwana@stltech.in
 * @version 1.0
 * @creatondate 2-aug-2021
 * @copyright sterlite technology ltd..
 * 
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.entities.User;
import com.phoenix.exceptions.UserNotFoundException;
import com.phoenix.repositories.UserRepository;
//service implementor class

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User findByUsername(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		/*
		 * Optional<User> op=userRepo.findById(username); if(op.isPresent()) return
		 * op.get(); else throws new
		 * UserNotFoundException("Sorry User"+username+"Not fond");
		 */
		return userRepo.findById(username).orElseThrow(()->new UserNotFoundException("Soory!"+username+" User Not Found"));
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepo.findAll();
	}

	@Override
	public void add(User user) {
		userRepo.save(user);
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(User user) {
		Optional<User>op=userRepo.findById(user.getUsername());
		if(op.isPresent()) {
			userRepo.save(user);
		}
		else
			System.out.println("Sorry! User Not Found ");
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(User user) {
		
		Optional<User>op=userRepo.findById(user.getUsername());
		if(op.isPresent()) {
			userRepo.delete(user);
		}
		else
			System.out.println("Soory! User Not Found");
		// TODO Auto-generated method stub

	}

}
