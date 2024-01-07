package io.faqb.links.repository;

import io.faqb.links.entity.LinksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinksRepository extends JpaRepository<LinksEntity,Integer> {

	List<LinksEntity> findByUserId(int userId);
}
