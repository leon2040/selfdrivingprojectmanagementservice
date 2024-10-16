package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ScheduleTrainingCommand {

    private String courseId;
    private Date trainingDate;
    private String trainingLocation;
}
