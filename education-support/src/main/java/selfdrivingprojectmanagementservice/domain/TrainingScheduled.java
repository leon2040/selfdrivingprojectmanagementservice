package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TrainingScheduled extends AbstractEvent {

    private String courseId;
    private Date trainingDate;
    private String trainingLocation;

    public TrainingScheduled(EducationCourse aggregate) {
        super(aggregate);
    }

    public TrainingScheduled() {
        super();
    }
}
//>>> DDD / Domain Event
