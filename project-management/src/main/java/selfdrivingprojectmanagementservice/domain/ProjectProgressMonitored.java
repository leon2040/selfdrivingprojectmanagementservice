package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProjectProgressMonitored extends AbstractEvent {

    private String projectId;

    public ProjectProgressMonitored(Project aggregate) {
        super(aggregate);
    }

    public ProjectProgressMonitored() {
        super();
    }
}
//>>> DDD / Domain Event
