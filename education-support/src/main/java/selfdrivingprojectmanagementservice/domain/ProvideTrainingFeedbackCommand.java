package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ProvideTrainingFeedbackCommand {

    private String courseId;
    private String feedback;
}
