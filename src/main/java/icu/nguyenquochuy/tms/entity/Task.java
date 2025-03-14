package icu.nguyenquochuy.tms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import icu.nguyenquochuy.tms.enums.TaskPriority;
import icu.nguyenquochuy.tms.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = true)  // Optional
    private Project project;

    private Date dueDate;
}
