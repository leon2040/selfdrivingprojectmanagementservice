package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CodingGuideRegistered extends AbstractEvent {

    private String guideId;
    private String guideName;
    private String guideContent;

    public CodingGuideRegistered(CodingGuide aggregate) {
        super(aggregate);
    }

    public CodingGuideRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
