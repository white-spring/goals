package com.white.helix.user.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author whiteSpring
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUp {
    private String userName;
    private String email;
    private String phone;
    /**
     * 明文密码
     */
    private String password;
}
