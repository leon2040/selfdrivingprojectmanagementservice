package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SystemPerformanceChecked extends AbstractEvent {

    private String projectId;

    public SystemPerformanceChecked(Project aggregate) {
        super(aggregate);
    }

    public SystemPerformanceChecked() {
        super();
    }
}
//>>> DDD / Domain Event
