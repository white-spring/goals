package com.white.helix.user.domain.service;

import com.white.helix.core.exception.ErrorException;
import com.white.helix.user.domain.entity.User;
import com.white.helix.user.domain.repository.UserRepository;
import com.white.helix.user.domain.vo.SignUp;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author whiteSpring
 */
@Service
@AllArgsConstructor
public class IUserService {

    private final UserRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUp param) {
        User user = new User(param);
        user.checkCreate();
        if (repository.existsByUserName(param.getUserName())) {
            throw new ErrorException("用户已存在");
        }
        repository.save(user);
    }

    public String login() {
        return null;
    }
}
