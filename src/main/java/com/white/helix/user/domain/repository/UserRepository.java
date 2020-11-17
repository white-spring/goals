package com.white.helix.user.domain.repository;

import com.white.helix.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author baichunqiang
 */
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> {

    boolean existsByEmailOrPhoneOrUserName(String email, String phone, String userName);

    boolean existsByUserName(String userName);

}



