package icu.nguyenquochuy.tms.service;

import icu.nguyenquochuy.tms.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskService{
    Task createTask(Task task);

    Page<Task> getTasks(Pageable pageable);

    Optional<Task> assignTaskToUser(Long userId, Long taskId);
}
