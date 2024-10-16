package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TrainingFeedbackProvided extends AbstractEvent {

    private String courseId;
    private String feedback;

    public TrainingFeedbackProvided(EducationCourse aggregate) {
        super(aggregate);
    }

    public TrainingFeedbackProvided() {
        super();
    }
}
//>>> DDD / Domain Event
