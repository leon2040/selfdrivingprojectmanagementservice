package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CodingGuideUpdated extends AbstractEvent {

    private String guideId;
    private String guideName;
    private String guideContent;

    public CodingGuideUpdated(CodingGuide aggregate) {
        super(aggregate);
    }

    public CodingGuideUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
