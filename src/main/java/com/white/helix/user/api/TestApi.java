package com.white.helix.user.api;

import com.white.helix.user.app.LevelUpService;
import com.white.helix.user.domain.entity.User;
import com.white.helix.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestApi {

    private final UserRepository repository;
    private final LevelUpService levelUpService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> learn() {

        User param = User.builder()
                .userName("test")
                .build();
        repository.save(param);
        return ResponseEntity.ok("sdf");
    }

    @GetMapping(value = "/level/up")
    public ResponseEntity<String> generic(String shell) {
        String result = levelUpService.runShell(shell);
        return ResponseEntity.ok(result);
    }
}
