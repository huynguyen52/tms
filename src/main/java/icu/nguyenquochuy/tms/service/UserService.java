package icu.nguyenquochuy.tms.service;

import icu.nguyenquochuy.tms.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    public Page<User> getUsers(Pageable pageable);

    User create(User user);
}
