package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.entity.MyUsers;
import com.cg.repository.MyUserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	MyUserRepo myUsersRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUsers> op = myUsersRepo.findById(username);
		if (op.isPresent()) {
			MyUsers user = op.get();
			return new MyUserDetail(user);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
