package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/valid")
/* valid: 유효성 검사 */
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<Void> findUserByNo() throws UserNotFoundException {
        boolean check = true;
        if (check) {
            /* UserNotFoundException: 사용자 정의 Exception */
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users")
    /* @Valid @RequestBody UserDTO user: 파라미터로 넘어오는 값의 유효성 검사 실행 명령 */
    public ResponseEntity<Void> registUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.created((URI.create("/valid/users/1"))).build();
    }
}
