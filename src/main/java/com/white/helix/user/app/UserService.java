package com.white.helix.user.app;

import java.util.Objects;

import com.white.helix.core.exception.ErrorException;
import com.white.helix.user.domain.repository.UserRepository;
import com.white.helix.user.domain.service.IUserService;
import com.white.helix.user.domain.vo.SignUp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author whiteSpring
 */
@Service
@AllArgsConstructor
public class UserService {

    private final IUserService domainService;
    private final UserRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUp param) {
        domainService.signUp(param);
    }

    public void login(String userName,String password) {
        Objects.requireNonNull(userName);
        if (repository.existsByUserName(userName)) {
            throw new ErrorException("用户不存在");
        }
    }

}
