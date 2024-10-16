package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import selfdrivingprojectmanagementservice.domain.*;
import selfdrivingprojectmanagementservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TrainingMaterialProvided extends AbstractEvent {

    private String courseId;
    private String materialId;

    public TrainingMaterialProvided(EducationCourse aggregate) {
        super(aggregate);
    }

    public TrainingMaterialProvided() {
        super();
    }
}
//>>> DDD / Domain Event
