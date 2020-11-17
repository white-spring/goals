package com.white.helix.user.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.white.helix.core.exception.ErrorException;
import com.white.helix.user.domain.vo.SignUp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;


/**
 * @author whiteSpring
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {


    public User(@NonNull SignUp signUp) {
        this.email = signUp.getEmail();
        this.phone = signUp.getPhone();
        this.userName = signUp.getUserName();
        this.password = signUp.getPassword();
    }

    /**
     * 用户创建数据合理性校验
     */
    public void checkCreate() {
        if (this.email == null && this.phone == null && this.userName == null) {
            throw new ErrorException("手机和email不能同时为空");
        }
        //todo email
        //todo phone
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(length = 100)
    private String userName;

    @Column(length = 18)
    private String phone;

    @Column(length = 120)
    private String email;

    @Column(length = 120)
    private String password;

    private String source;

}
