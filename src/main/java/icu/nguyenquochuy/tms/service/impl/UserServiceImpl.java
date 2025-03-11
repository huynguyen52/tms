package icu.nguyenquochuy.tms.service.impl;

import icu.nguyenquochuy.tms.entity.User;
import icu.nguyenquochuy.tms.repository.UserRepository;
import icu.nguyenquochuy.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
