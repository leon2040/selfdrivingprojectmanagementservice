package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProjectUpdated extends AbstractEvent {

    private String projectId;
    private String projectName;
    private String projectDescription;

    public ProjectUpdated(Project aggregate) {
        super(aggregate);
    }

    public ProjectUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
