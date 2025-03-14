package icu.nguyenquochuy.tms.controller;

import icu.nguyenquochuy.tms.entity.User;
import icu.nguyenquochuy.tms.service.UserService;
import icu.nguyenquochuy.tms.vo.PaginationResponseVO;
import icu.nguyenquochuy.tms.vo.ResponseVO;
import icu.nguyenquochuy.tms.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("${tms.api.user.url}")
    public PaginationResponseVO<UserVO> getUsers(Pageable pageable) {
        Page<User> userPage = userService.getUsers(pageable);
        return PaginationResponseVO.success(
                userPage.getContent().stream().map(UserVO::from),
                userPage.getNumber(),
                userPage.getSize(),
                userPage.getTotalElements()
        );
    }

    @PostMapping("${tms.api.user.create.url}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseVO<UserVO> createUser(@RequestBody User user) {
        UserVO userVO = Optional.of(userService.create(user)).map(UserVO::from).get();
        return ResponseVO.created("", userVO);
    }
}
