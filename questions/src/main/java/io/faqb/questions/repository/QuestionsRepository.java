package io.faqb.questions.repository;

import io.faqb.questions.entity.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface QuestionsRepository extends JpaRepository<QuestionsEntity,Integer> {

	List<QuestionsEntity> findByUserId(int userId);

	@Modifying
	@Query("update QuestionsEntity q set q.groupName = ?3 where q.userId = ?1 and q.groupId = ?2")
	void updateGroupNames(int userId, int groupId, String groupName);

	@Modifying
	@Query("update QuestionsEntity  q set q.groupId = null, q.groupName = null where q.userId = ?1 and q.groupId = ?2")
	void updateDeletedGroups(int userId, int groupId);
}
