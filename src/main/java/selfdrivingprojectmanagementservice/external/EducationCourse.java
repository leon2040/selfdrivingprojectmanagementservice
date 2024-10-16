package selfdrivingprojectmanagementservice.external;

import java.util.Date;
import lombok.Data;

@Data
public class EducationCourse {

    private String courseId;
    private String courseName;
    private String courseDescription;
    private String courseStatus;
    private Object courseStatusType;
}
