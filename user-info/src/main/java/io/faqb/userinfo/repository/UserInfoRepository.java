package io.faqb.userinfo.repository;

import io.faqb.userinfo.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {

}
