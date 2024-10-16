package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProjectRegistered extends AbstractEvent {

    private String projectId;
    private String projectName;
    private String projectDescription;
    private String projectStatus;

    public ProjectRegistered(Project aggregate) {
        super(aggregate);
    }

    public ProjectRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
