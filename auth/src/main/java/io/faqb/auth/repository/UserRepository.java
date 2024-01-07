package io.faqb.auth.repository;

import io.faqb.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

	Optional<UserEntity> findByUserName(String username);

	@Transactional
	@Modifying
	@Query("update UserEntity u set u.userName = ?1 where u.userId = ?2")
	void updateUsername(String username, Integer userId);

	@Transactional
	@Modifying
	@Query("update UserEntity u set u.mail = ?1 where u.userId = ?2")
	void updateMail(String mail, Integer userId);

	@Transactional
	@Modifying
	@Query("update UserEntity u set u.password = ?1 where u.userId = ?2")
	void updatePassword(String password, Integer userId);
}
