package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AssignTaskCommand {

    private String projectId;
    private String taskId;
}
