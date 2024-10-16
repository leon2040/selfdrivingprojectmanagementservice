package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProjectDeleted extends AbstractEvent {

    private String projectId;

    public ProjectDeleted(Project aggregate) {
        super(aggregate);
    }

    public ProjectDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
