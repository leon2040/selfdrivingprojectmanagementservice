package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FeedbackProvided extends AbstractEvent {

    private String projectId;
    private String feedback;

    public FeedbackProvided(Project aggregate) {
        super(aggregate);
    }

    public FeedbackProvided() {
        super();
    }
}
//>>> DDD / Domain Event
