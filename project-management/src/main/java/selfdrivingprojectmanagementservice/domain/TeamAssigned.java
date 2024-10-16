package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TeamAssigned extends AbstractEvent {

    private String projectId;
    private String teamMemberId;

    public TeamAssigned(Project aggregate) {
        super(aggregate);
    }

    public TeamAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
