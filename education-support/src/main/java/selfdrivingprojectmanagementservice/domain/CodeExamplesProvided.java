package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CodeExamplesProvided extends AbstractEvent {

    private String courseId;
    private String exampleId;

    public CodeExamplesProvided(EducationCourse aggregate) {
        super(aggregate);
    }

    public CodeExamplesProvided() {
        super();
    }
}
//>>> DDD / Domain Event
