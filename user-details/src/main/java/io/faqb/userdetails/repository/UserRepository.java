package io.faqb.userdetails.repository;

import io.faqb.userdetails.entity.UserDetailsEntity;
import io.faqb.userdetails.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	Optional<UserEntity> findByUserName(String username);

	Optional<UserEntity> findByMail(String mail);

}

