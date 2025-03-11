package icu.nguyenquochuy.tms.controller;

import icu.nguyenquochuy.tms.entity.User;
import icu.nguyenquochuy.tms.service.UserService;
import icu.nguyenquochuy.tms.vo.PaginationResponseVO;
import icu.nguyenquochuy.tms.vo.ResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("${tms.api.user.url}")
    public ResponseEntity<PaginationResponseVO<User>> getUsers(Pageable pageable) {
        Page<User> userPage = userService.getUsers(pageable);
        PaginationResponseVO<User> response = PaginationResponseVO.success(
                userPage.getContent(),
                userPage.getNumber(),
                userPage.getSize(),
                userPage.getTotalElements()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("${tms.api.user.create.url}")
    public ResponseEntity<ResponseVO<User>> createUser(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity.ok(ResponseVO.created("", createdUser));
    }
}
