package icu.nguyenquochuy.tms.service.impl;

import icu.nguyenquochuy.tms.entity.Task;
import icu.nguyenquochuy.tms.entity.User;
import icu.nguyenquochuy.tms.repository.TaskRepository;
import icu.nguyenquochuy.tms.repository.UserRepository;
import icu.nguyenquochuy.tms.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Page<Task> getTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public Optional<Task> assignTaskToUser(Long userId, Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        Optional<User> userOptional = userRepository.findById(userId);
        if (taskOptional.isPresent() && userOptional.isPresent()) {
            Task task = taskOptional.get();
            User user = userOptional.get();
            task.setAssignedUser(user);
            return Optional.of(taskRepository.save(task));
        };
        return Optional.empty();
    }
}
