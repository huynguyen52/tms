package icu.nguyenquochuy.tms.controller;

import icu.nguyenquochuy.tms.entity.Task;
import icu.nguyenquochuy.tms.service.TaskService;
import icu.nguyenquochuy.tms.vo.PaginationResponseVO;
import icu.nguyenquochuy.tms.vo.ResponseVO;
import icu.nguyenquochuy.tms.vo.TaskVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("${tms.api.task.url}")
    PaginationResponseVO<TaskVO> getTasks(Pageable pageable) {
        Page<Task> tasks = taskService.getTasks(pageable);
        return PaginationResponseVO.success(
                tasks.getContent().stream().map(TaskVO::from),
                tasks.getNumber(),
                tasks.getSize(),
                tasks.getTotalElements()
        );
    }

    @PostMapping("${tms.api.task.create.url}")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseVO<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseVO.created("", createdTask);
    }

    @GetMapping("${tms.api.task.assign.url}")
    @ResponseStatus(HttpStatus.OK)
    ResponseVO<TaskVO> assignTask(
            @PathVariable("taskId") Long taskId,
            @PathVariable("userId") Long userId
    ) {
        Optional<Task> updatedTask = taskService.assignTaskToUser(userId, taskId);
        return updatedTask
                .map(TaskVO::from)
                .map(ResponseVO::success).get();
    }
}
