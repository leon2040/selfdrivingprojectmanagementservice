package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import selfdrivingprojectmanagementservice.ProjectManagementApplication;
import selfdrivingprojectmanagementservice.domain.FeedbackProvided;
import selfdrivingprojectmanagementservice.domain.ProjectDeleted;
import selfdrivingprojectmanagementservice.domain.ProjectProgressMonitored;
import selfdrivingprojectmanagementservice.domain.ProjectRegistered;
import selfdrivingprojectmanagementservice.domain.SystemPerformanceChecked;

@Entity
@Table(name = "Project_table")
@Data
//<<< DDD / Aggregate Root
public class Project {

    @Id
    private String projectId;

    private String projectName;

    private String projectDescription;

    private String projectStatus;

    @Enumerated(EnumType.STRING)
    private projectStatusType projectStatusType;

    @PostPersist
    public void onPostPersist() {
        ProjectRegistered projectRegistered = new ProjectRegistered(this);
        projectRegistered.publishAfterCommit();

        ProjectDeleted projectDeleted = new ProjectDeleted(this);
        projectDeleted.publishAfterCommit();

        ProjectProgressMonitored projectProgressMonitored = new ProjectProgressMonitored(
            this
        );
        projectProgressMonitored.publishAfterCommit();

        SystemPerformanceChecked systemPerformanceChecked = new SystemPerformanceChecked(
            this
        );
        systemPerformanceChecked.publishAfterCommit();

        FeedbackProvided feedbackProvided = new FeedbackProvided(this);
        feedbackProvided.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ProjectRepository repository() {
        ProjectRepository projectRepository = ProjectManagementApplication.applicationContext.getBean(
            ProjectRepository.class
        );
        return projectRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateProject(UpdateProjectCommand updateProjectCommand) {
        //implement business logic here:

        ProjectUpdated projectUpdated = new ProjectUpdated(this);
        projectUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void assignTeamMember(
        AssignTeamMemberCommand assignTeamMemberCommand
    ) {
        //implement business logic here:

        TeamAssigned teamAssigned = new TeamAssigned(this);
        teamAssigned.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void assignTask(AssignTaskCommand assignTaskCommand) {
        //implement business logic here:

        TaskAssigned taskAssigned = new TaskAssigned(this);
        taskAssigned.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
