package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TaskAssigned extends AbstractEvent {

    private String projectId;
    private String taskId;

    public TaskAssigned(Project aggregate) {
        super(aggregate);
    }

    public TaskAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
