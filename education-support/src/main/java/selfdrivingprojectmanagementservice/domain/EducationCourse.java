package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import selfdrivingprojectmanagementservice.EducationSupportApplication;
import selfdrivingprojectmanagementservice.domain.CodeExamplesProvided;
import selfdrivingprojectmanagementservice.domain.TrainingFeedbackProvided;
import selfdrivingprojectmanagementservice.domain.TrainingMaterialProvided;
import selfdrivingprojectmanagementservice.domain.TrainingScheduled;

@Entity
@Table(name = "EducationCourse_table")
@Data
//<<< DDD / Aggregate Root
public class EducationCourse {

    @Id
    private String courseId;

    private String courseName;

    private String courseDescription;

    private String courseStatus;

    @Enumerated(EnumType.STRING)
    private courseStatusType courseStatusType;

    @PostPersist
    public void onPostPersist() {
        TrainingScheduled trainingScheduled = new TrainingScheduled(this);
        trainingScheduled.publishAfterCommit();

        TrainingMaterialProvided trainingMaterialProvided = new TrainingMaterialProvided(
            this
        );
        trainingMaterialProvided.publishAfterCommit();

        CodeExamplesProvided codeExamplesProvided = new CodeExamplesProvided(
            this
        );
        codeExamplesProvided.publishAfterCommit();

        TrainingFeedbackProvided trainingFeedbackProvided = new TrainingFeedbackProvided(
            this
        );
        trainingFeedbackProvided.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static EducationCourseRepository repository() {
        EducationCourseRepository educationCourseRepository = EducationSupportApplication.applicationContext.getBean(
            EducationCourseRepository.class
        );
        return educationCourseRepository;
    }
}
//>>> DDD / Aggregate Root
