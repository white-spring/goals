package com.white.helix.user.domain.repository;

import com.white.helix.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author baichunqiang
 */
interface UserRepositoryCustom {

    int countBy(String userName);

}
