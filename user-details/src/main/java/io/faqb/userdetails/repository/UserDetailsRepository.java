package io.faqb.userdetails.repository;

import io.faqb.userdetails.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Integer> {

	Optional<UserDetailsEntity> findByUsername(String username);

	Optional<UserDetailsEntity> findByMail(String mail);
}
