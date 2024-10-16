package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterProjectCommand {

    private String projectId;
    private String projectName;
    private String projectDescription;
}
