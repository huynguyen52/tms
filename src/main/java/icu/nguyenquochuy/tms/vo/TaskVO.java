package icu.nguyenquochuy.tms.vo;

import icu.nguyenquochuy.tms.entity.Task;
import icu.nguyenquochuy.tms.enums.TaskPriority;
import icu.nguyenquochuy.tms.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
public class TaskVO {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private UserVO assignedUser;
    private Date dueDate;

    public static TaskVO from(Task task) {
        return TaskVO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .dueDate(task.getDueDate())
                .assignedUser(task.getAssignedUser() != null ? UserVO.from(task.getAssignedUser()) : null)
                .build();
    }
}
