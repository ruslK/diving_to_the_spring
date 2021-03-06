package com.ticketsproject.entities;

import com.ticketsproject.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class Project extends BaseEntity {

    private String projectName;
    @Column(unique = true)
    private String projectCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetails;
    @Enumerated(EnumType.STRING)
    private Status projectStatus;
    private int completeCount;
    private int inCompleteCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User assignedManager;
}
