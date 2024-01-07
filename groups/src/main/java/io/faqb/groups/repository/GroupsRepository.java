package io.faqb.groups.repository;

import io.faqb.groups.entity.GroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsRepository extends JpaRepository<GroupsEntity, Integer> {

	List<GroupsEntity> findByUserId(int userId);
}
