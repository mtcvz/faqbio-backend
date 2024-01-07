package io.faqb.auth.service;

import io.faqb.auth.entity.UserEntity;
import io.faqb.auth.model.User;
import io.faqb.auth.model.UserRequest;
import io.faqb.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	@Lazy
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> userEntityOptional = userRepository.findByUserName(username);
		if (!userEntityOptional.isPresent()){
			throw new UsernameNotFoundException(username + " not found.");
		}

		return new User(userEntityOptional.get());
	}

	public UserEntity saveUser(UserRequest request){
		//UserDetails userDetails = populateUserData(request);
		UserEntity entity = new UserEntity();
		entity.setActive(true);
		entity.setPassword(passwordEncoder.encode(request.getPassword()));
		entity.setUserName(request.getUsername());
		entity.setRoles("USER");
		entity.setMail(request.getMail());
		return userRepository.save(entity);
	}

	public UserEntity updateUsername(UserRequest request){
		userRepository.updateUsername(request.getUsername(), request.getUserId());
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(request.getUserId());
		userEntity.setUserName(request.getUsername());
		return userEntity;
	}

	public UserEntity updateMail(UserRequest request){
		userRepository.updateMail(request.getMail(), request.getUserId());
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(request.getUserId());
		return userEntity;
	}

	public UserEntity updatePassword(UserRequest request){
		userRepository.updatePassword(passwordEncoder.encode(request.getPassword()), request.getUserId());
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(request.getUserId());
		return userEntity;
	}

	public UserEntity getUser(UserRequest request){
		Optional<UserEntity> userEntityOptional;
		userEntityOptional = userRepository.findByUserName(request.getUsername());
		if(!userEntityOptional.isPresent()){
			return null;
		}
		return userEntityOptional.get();
	}

	/*
	public UserDetails populateUserData(final UserRequest request){
		UserDetails userDetails = new User(request.getUsername(), request.getPassword());
		return userDetails;
	}

	 */

}
