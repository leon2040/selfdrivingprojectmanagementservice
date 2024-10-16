package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CodingGuideProvided extends AbstractEvent {

    private String guideId;
    private String guideContent;

    public CodingGuideProvided(CodingGuide aggregate) {
        super(aggregate);
    }

    public CodingGuideProvided() {
        super();
    }
}
//>>> DDD / Domain Event
