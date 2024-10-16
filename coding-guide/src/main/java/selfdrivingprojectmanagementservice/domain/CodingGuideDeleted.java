package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CodingGuideDeleted extends AbstractEvent {

    private String guideId;

    public CodingGuideDeleted(CodingGuide aggregate) {
        super(aggregate);
    }

    public CodingGuideDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
