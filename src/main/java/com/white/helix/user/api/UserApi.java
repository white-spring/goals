package com.white.helix.user.api;

import com.white.helix.user.app.UserService;
import com.white.helix.user.domain.vo.SignUp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whiteSpring
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<Void> signup(@RequestBody SignUp param) {
        userService.signUp(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestParam("email") String email,
                                      @RequestParam("phone") String phone,
                                      @RequestParam("password") String password) {

        return ResponseEntity.ok().build();
    }
}
