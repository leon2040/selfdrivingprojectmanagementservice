package selfdrivingprojectmanagementservice.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class ScheduleTrainingCommand {

    @Id
    private String courseId;

    private Date trainingDate;
    private String trainingLocation;
}
